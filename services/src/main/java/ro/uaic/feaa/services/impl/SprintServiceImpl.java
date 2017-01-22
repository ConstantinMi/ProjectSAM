package ro.uaic.feaa.services.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.dto.SprintDTO;
import ro.uaic.feaa.exceptions.ActiveSprintException;
import ro.uaic.feaa.exceptions.SprintNotFoundException;
import ro.uaic.feaa.models.Sprint;
import ro.uaic.feaa.services.ISprintService;
import ro.uaic.feaa.services.utils.SprintUtils;
import ro.uaic.feaa.storage.ISprintDAO;

import java.util.Optional;

/**
 * Created by Claudiu on 1/10/2017.
 */

@Service
@Transactional
public class SprintServiceImpl implements ISprintService{

    private static final String NOT_FOUND = "No sprint found with the specified id";
    private static final String BAD_REQUEST = "Active sprint already existing";

    @Autowired
    private ISprintDAO sprintDAO;

    @Override
    public SprintDTO addSprint(SprintDTO sprintDTO) {
        Optional<Sprint> existingSprint =
                sprintDAO.findActiveSprint(getDateFormatted(sprintDTO.getStartDate()));

        if (!existingSprint.isPresent()) {
            Sprint sprint = SprintUtils.fromDTOToModel(sprintDTO);
            sprint.setSprintNo(constructSprintName());
            sprint = sprintDAO.createNew(sprint);

            return SprintUtils.fromModelToDTO(sprint);
        } else
            throw new ActiveSprintException(BAD_REQUEST);
    }

    @Override
    public SprintDTO updateSprint(Long sprintId, SprintDTO sprintDTO) {
        Optional<Sprint> existingSprint = sprintDAO.findById(sprintId);

        if (existingSprint.isPresent()) {
            existingSprint.get().setEndDate(getDateFormatted(sprintDTO.getEndDate()));
            sprintDAO.update(existingSprint.get());

            return SprintUtils.fromModelToDTO(existingSprint.get());
        } else
            throw new SprintNotFoundException(NOT_FOUND);
    }

    @Override
    public SprintDTO getSprintInfo(Long sprintId) {
        Optional<Sprint> existingSprint = sprintDAO.findById(sprintId);

        if (existingSprint.isPresent()) {
            return SprintUtils.fromModelToDTO(existingSprint.get());
        } else
            throw new SprintNotFoundException(NOT_FOUND);
    }

    private DateTime getDateFormatted(String date) {
        return SprintUtils.getDateTimeFromString(date);
    }

    private String constructSprintName() {
        Optional<Sprint> existingSprint = sprintDAO.findMostRecentSprint();

        return existingSprint
                .map(s -> {
                    int temp = Integer.parseInt(s.getSprintNo().split("_")[2]);
                    return "SAM_SPRINT_" + ++temp;
                })
                .orElse("SAM_SPRINT_1");
    }
}
