package ro.uaic.feaa.services;

import ro.uaic.feaa.dto.FeatureDTO;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.models.Feature;

import java.util.List;

/**
 * Created by Claudiu on 1/12/2017.
 */
public interface IFeatureService {

    FeatureDTO addFeature(String username, String projectName, Long sprintId, FeatureDTO featureDTO);

    FeatureDTO updateFeature(Long featureId, FeatureDTO featureDTO);

    void deleteFeature(Long featureId);

    FeatureDTO getByName(String featureName);

    List<FeatureDTO> getAllFeatures(String projectName);

}
