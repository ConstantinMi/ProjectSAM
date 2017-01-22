package ro.uaic.feaa.services.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.dto.SubFeatureDTO;
import ro.uaic.feaa.enums.FeatureState;
import ro.uaic.feaa.exceptions.FeatureNotFoundException;
import ro.uaic.feaa.exceptions.SubFeatureNotFoundException;
import ro.uaic.feaa.models.Feature;
import ro.uaic.feaa.models.Person;
import ro.uaic.feaa.models.SubFeature;
import ro.uaic.feaa.services.ISubFeatureService;
import ro.uaic.feaa.services.utils.SubfeatureUtils;
import ro.uaic.feaa.storage.IFeatureDAO;
import ro.uaic.feaa.storage.IPersonDAO;
import ro.uaic.feaa.storage.ISubfeatureDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Claudiu on 1/22/2017.
 */
@Service
@Transactional
public class SubFeatureServiceImpl implements ISubFeatureService{

    @Autowired
    private ISubfeatureDAO subfeatureDAO;

    @Autowired
    private IFeatureDAO featureDAO;

    @Autowired
    private IPersonDAO personDAO;


    @Override
    public SubFeatureDTO addSubFeature(String username, Long featureId, SubFeatureDTO subFeatureDTO) {
        Optional<Person> existingPerson = personDAO.findByUsername(username);
        Optional<Feature> existingFeature = featureDAO.findById(featureId);

        if (!existingFeature.isPresent() && !existingPerson.isPresent()) {
            throw new FeatureNotFoundException("Feature and reporter not found!");
        } else {
            SubFeature subFeature = SubfeatureUtils.fromDTOToModel(subFeatureDTO);
            subFeature.setReporter(existingPerson.get());
            return SubfeatureUtils.fromModelToDTO(subfeatureDAO.createNew(subFeature));
        }
    }

    @Override
    public SubFeatureDTO updateSubFeature(Long subFeatureId, SubFeatureDTO subFeatureDTO) {
        Optional<SubFeature> existingSubFeature = subfeatureDAO.findById(subFeatureId);
        Optional<Person> existingPerson = Optional.empty();

        if (subFeatureDTO.getAssignee() != null) {
            existingPerson = personDAO.findByUsername(subFeatureDTO.getAssignee());
        }
        if (existingSubFeature.isPresent()) {
            existingSubFeature.get().setAsignee(existingPerson.get());
            existingSubFeature.get().setUpdated(DateTime.now());
            existingSubFeature.get().setDescription(subFeatureDTO.getDescription() != null
                    ? subFeatureDTO.getDescription() : existingSubFeature.get().getDescription());
            existingSubFeature.get().setState(subFeatureDTO.getState() != null
                    ? FeatureState.valueOfKey(subFeatureDTO.getState()) : existingSubFeature.get().getState());

            return SubfeatureUtils.fromModelToDTO(subfeatureDAO.update(existingSubFeature.get()));
        } else
            throw new SubFeatureNotFoundException("SubFeature not found");
    }

    @Override
    public void delete(Long subFeatureId) {
        subfeatureDAO.delete(subFeatureId);
    }

    @Override
    public List<SubFeatureDTO> getSubFeatures(Long featureId) {
        Optional<Feature> existingFeature = featureDAO.findById(featureId);
        if (existingFeature.isPresent()) {
            return existingFeature.get().getSubFeatures().stream().map(SubfeatureUtils::fromModelToDTO).collect(Collectors.toList());
        } else
            throw new FeatureNotFoundException("Feature with id " + featureId + " not found");
    }

}
