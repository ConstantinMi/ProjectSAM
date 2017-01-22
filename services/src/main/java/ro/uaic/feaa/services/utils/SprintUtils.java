package ro.uaic.feaa.services.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ro.uaic.feaa.dto.SprintDTO;
import ro.uaic.feaa.models.Sprint;


/**
 * Created by Claudiu on 1/10/2017.
 */
@Component
public class SprintUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd.MM.yyyy");

    public static SprintDTO fromModelToDTO(Sprint sprint) {
        SprintDTO sprintDTO = new SprintDTO();

        sprintDTO.setId(sprint.getId());
        sprintDTO.setStartDate(FORMATTER.print(sprint.getStartDate()));
        sprintDTO.setEndDate(FORMATTER.print(sprint.getEndDate()));
        sprintDTO.setSprintNo(sprint.getSprintNo());

        return sprintDTO;
    }

    public static Sprint fromDTOToModel(SprintDTO sprintDTO) {
        Sprint sprint = new Sprint();
        if (sprintDTO.getStartDate() != null && !StringUtils.isEmpty(sprintDTO.getStartDate())) {
            sprint.setStartDate(FORMATTER.parseDateTime(sprintDTO.getStartDate()));
        } else
            sprint.setStartDate(new DateTime());
        sprint.setEndDate(sprint.getStartDate().plusWeeks(sprintDTO.getNoOfWeeks().intValue()));

        return sprint;
    }

    public static DateTime getDateTimeFromString(String date) {
        return FORMATTER.parseDateTime(date);
    }
}
