package ro.uaic.feaa.services;

import ro.uaic.feaa.dto.SubFeatureDTO;

import java.util.List;

/**
 * Created by Claudiu on 1/22/2017.
 */
public interface ISubFeatureService {

    SubFeatureDTO addSubFeature(String username, Long featureId, SubFeatureDTO subFeatureDTO);

    SubFeatureDTO updateSubFeature(Long subfeatureId, SubFeatureDTO subFeatureDTO);

    void delete(Long subfeatureId);

    List<SubFeatureDTO> getSubFeatures(Long featureId);

}
