package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.SubFeatureDTO;
import ro.uaic.feaa.services.ISubFeatureService;

import java.security.Principal;
import java.util.List;

/**
 * Created by Claudiu on 1/24/2017.
 */
@RestController
@RequestMapping("/me/projects/{projectName}/sprint/{sprintId}/features/{featureId}")
public class SubFeatureController {

    @Autowired
    private ISubFeatureService subFeatureService;

    @RequestMapping(path = "/subFeatures", method = RequestMethod.POST)
    public SubFeatureDTO addSubFeature(Principal principal,
                                       @PathVariable("featureId") Long featureId,
                                       @RequestBody SubFeatureDTO subFeatureDTO) {
        return subFeatureService.addSubFeature(principal.getName(), featureId, subFeatureDTO);
    }

    @RequestMapping(path = "/subFeatures/{subFeatureId}", method = RequestMethod.PUT)
    public SubFeatureDTO updateSubFeature(@PathVariable("subFeatureId") Long subFeatureId,
                                          @RequestBody SubFeatureDTO subFeatureDTO) {
        return subFeatureService.updateSubFeature(subFeatureId, subFeatureDTO);
    }

    @RequestMapping(path = "subFeatures",method = RequestMethod.GET)
    public List<SubFeatureDTO> getSubFeatures(@PathVariable("featureId") Long featureId) {
        return subFeatureService.getSubFeatures(featureId);
    }

    @RequestMapping(path = "/subFeatures/{subFeatureId}", method = RequestMethod.DELETE)
    public void deleteSubFeature(@PathVariable("subFeatureId") Long subFeatureId) {
        subFeatureService.delete(subFeatureId);
    }

}
