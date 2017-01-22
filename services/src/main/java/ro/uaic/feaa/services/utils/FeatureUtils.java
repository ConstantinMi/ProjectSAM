package ro.uaic.feaa.services.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import ro.uaic.feaa.dto.FeatureDTO;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.dto.SubFeatureDTO;
import ro.uaic.feaa.enums.FeatureState;
import ro.uaic.feaa.enums.IssueType;
import ro.uaic.feaa.enums.Priority;
import ro.uaic.feaa.models.Feature;

/**
 * Created by Claudiu on 1/12/2017.
 */
@Component
public class FeatureUtils {

    public static FeatureDTO fromModelTODTO(Feature feature) {
        FeatureDTO featureDTO = new FeatureDTO();

        featureDTO.setId(feature.getId());
        featureDTO.setTitle(feature.getTitle());
        featureDTO.setDescription(feature.getDescription());
        featureDTO.setAssignee(feature.getAsignee() != null
                ? feature.getAsignee().getFirstName() + " " + feature.getAsignee().getLastName() : null);
        featureDTO.setIssueType(feature.getIssueType() != null ? feature.getIssueType().getKey() : null);
        featureDTO.setReporter(feature.getReporter().getFirstName() + " " + feature.getReporter().getLastName());
        featureDTO.setState(feature.getState() != null ? feature.getState().getKey() : null);
        featureDTO.setStoryPoints((long)feature.getStoryPoints());
        featureDTO.setPriority(feature.getPriority() != null ? feature.getPriority().getKey() : null);

        return featureDTO;
    }

    public static Feature fromDtoToModel(FeatureDTO featureDTO) {
        Feature feature = new Feature();

        feature.setTitle(featureDTO.getTitle());
        feature.setDescription(featureDTO.getDescription());
        feature.setIssueType(IssueType.valueOfKey(featureDTO.getIssueType()));
        feature.setState(FeatureState.valueOfKey(featureDTO.getState()));
        feature.setStoryPoints((int)(long)featureDTO.getStoryPoints());
        feature.setPriority(Priority.valueOfKey(featureDTO.getPriority()));
        feature.setCreated(DateTime.now());

        return feature;
    }

}
