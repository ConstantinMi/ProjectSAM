package ro.uaic.feaa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.dto.FeatureDTO;
import ro.uaic.feaa.exceptions.*;
import ro.uaic.feaa.models.*;
import ro.uaic.feaa.services.IFeatureService;
import ro.uaic.feaa.services.utils.FeatureUtils;
import ro.uaic.feaa.storage.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Claudiu on 1/12/2017.
 */
@Service
@Transactional
public class FeatureServiceImpl implements IFeatureService {

    @Autowired
    private IFeatureDAO featureDAO;

    @Autowired
    private IProjectDAO projectDAO;

    @Autowired
    private ISprintDAO sprintDAO;

    @Autowired
    private IPersonDAO personDAO;

    @Override
    public FeatureDTO addFeature(String username, String projectName, Long sprintId, FeatureDTO featureDTO) {
        Optional<Project> existingProject = projectDAO.findByName(projectName);
        Optional<Sprint> existingSprint = sprintDAO.findById(sprintId);
        Optional<Person> existingPerson = personDAO.findByUsername(username);
        Optional<Feature> existingFeature = featureDAO.findByName(featureDTO.getTitle());

        if (!existingPerson.isPresent() || !existingPerson.isPresent()) {
            throw new PersonalDetailsNotFoundException("Personal details not found");
        }
        if (!existingSprint.isPresent()) {
            throw new SprintNotFoundException("No sprint found with the specified id");
        }
        if (!existingProject.isPresent()) {
            throw new ProjectNotFoundException("No project found with the specified name");
        }
        if (existingFeature.isPresent()) {
            throw new UniqueFeatureException("Feature already existing with the specified title");
        }

        Feature feature = FeatureUtils.fromDtoToModel(featureDTO);
        feature.setReporter(existingPerson.get());
        feature.setSprint(existingSprint.get());
        feature.setProject(existingProject.get());

        feature = featureDAO.createNew(feature);

        return FeatureUtils.fromModelTODTO(feature);
    }

    @Override
    public FeatureDTO updateFeature(Long featureId, FeatureDTO featureDTO) {
        Optional<Feature> existingFeature = featureDAO.findById(featureId);
        Optional<Person> existingPerson = Optional.empty();

        if (featureDTO.getAssignee() != null && !featureDTO.getAssignee().isEmpty()) {
            existingPerson = personDAO.findByUsername(featureDTO.getAssignee());
        }

        if (existingFeature.isPresent()) {
            existingFeature.get().setAsignee(existingPerson.isPresent() ? existingPerson.get() : null);
            existingFeature.get().setTitle(featureDTO.getTitle() != null ? featureDTO.getTitle() : existingFeature.get().getTitle());
            existingFeature.get().setDescription(featureDTO.getDescription() != null
                    ? featureDTO.getDescription() : existingFeature.get().getDescription());
            existingFeature.get().setComment(featureDTO.getComment() != null
                    ? featureDTO.getDescription() : existingFeature.get().getDescription());

            return FeatureUtils.fromModelTODTO(featureDAO.update(existingFeature.get()));
        } else
            throw new FeatureNotFoundException("No feature found with the specified id");
    }

    @Override
    public void deleteFeature(Long featureId) {
        featureDAO.delete(featureId);
    }

    @Override
    public FeatureDTO getByName(String featureName) {
        Optional<Feature> existingFeature = featureDAO.findByName(featureName);

        if (existingFeature.isPresent()) {
            return FeatureUtils.fromModelTODTO(existingFeature.get());
        } else
            throw new FeatureNotFoundException("No feature found with the specified name");
    }

    @Override
    public List<FeatureDTO> getAllFeatures(String projectName) {
        return featureDAO.findByProject(projectName).stream().map(FeatureUtils::fromModelTODTO).collect(Collectors.toList());
    }
}
