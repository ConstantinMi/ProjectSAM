package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.FeatureDTO;
import ro.uaic.feaa.services.IFeatureService;

import java.security.Principal;
import java.util.List;

/**
 * Created by Claudiu on 1/12/2017.
 */
@RestController
@RequestMapping("/me/projects/{projectName}")
public class FeatureController {

    @Autowired
    private IFeatureService featureService;

    @RequestMapping(method = RequestMethod.GET)
    public List<FeatureDTO> getAllFeatures(@PathVariable("projectName") String projectName) {
        return featureService.getAllFeatures(projectName);
    }

    @RequestMapping(path = "/sprint/{sprintId}/features", method = RequestMethod.POST)
    public FeatureDTO addFeature(Principal principal,
                                 @PathVariable String projectName,
                                 @PathVariable Long sprintId,
                                 @RequestBody FeatureDTO featureDTO) {
        return featureService.addFeature(principal.getName(), projectName, sprintId, featureDTO);
    }

    @RequestMapping(path = "/features/{featureId}", method = RequestMethod.DELETE)
    public void deleteFeature(@PathVariable("featureId") Long featureId) {
        featureService.deleteFeature(featureId);
    }

}
