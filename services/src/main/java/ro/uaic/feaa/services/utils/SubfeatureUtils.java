package ro.uaic.feaa.services.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import ro.uaic.feaa.dto.SubFeatureDTO;
import ro.uaic.feaa.enums.FeatureState;
import ro.uaic.feaa.enums.IssueType;
import ro.uaic.feaa.models.SubFeature;

/**
 * Created by Claudiu on 1/22/2017.
 */
@Component
public class SubfeatureUtils {


    public static SubFeatureDTO fromModelToDTO(SubFeature subFeature) {
        SubFeatureDTO subFeatureDTO = new SubFeatureDTO();

        subFeatureDTO.setId(subFeature.getId());
        subFeatureDTO.setTitle(subFeature.getTitle());
        subFeatureDTO.setDescription(subFeature.getDescription());
        subFeatureDTO.setState(subFeature.getState().getKey());
        subFeatureDTO.setIssueType(subFeature.getIssueType().getKey());
        subFeatureDTO.setAssignee(subFeature.getAsignee() != null ?
                subFeature.getAsignee().getFirstName() + " " +subFeature.getAsignee().getLastName() : null);
        subFeatureDTO.setReporter(subFeature.getReporter().getFirstName() + " " + subFeature.getReporter().getLastName());
        subFeatureDTO.setCreated(subFeature.getCreated().toString());
        subFeatureDTO.setUpdated(subFeature.getUpdated() != null ? subFeature.getUpdated().toString() : null);
        subFeatureDTO.setComment(subFeature.getComment());

        return subFeatureDTO;
    }

    public static SubFeature fromDTOToModel(SubFeatureDTO subFeatureDTO) {
        SubFeature subFeature = new SubFeature();

        subFeature.setTitle(subFeatureDTO.getTitle());
        subFeature.setDescription(subFeatureDTO.getDescription());
        subFeature.setState(FeatureState.valueOfKey(subFeatureDTO.getState()));
        subFeature.setIssueType(IssueType.valueOfKey(subFeatureDTO.getIssueType()));
        subFeature.setComment(subFeatureDTO.getComment());
        subFeature.setCreated(DateTime.now());

        return subFeature;
    }



}
