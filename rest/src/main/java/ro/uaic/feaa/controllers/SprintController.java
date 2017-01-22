package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.SprintDTO;
import ro.uaic.feaa.services.ISprintService;

/**
 * Created by Claudiu on 1/10/2017.
 */
@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private ISprintService sprintService;

    @RequestMapping(method = RequestMethod.POST)
    public SprintDTO addNewSprint(@RequestBody SprintDTO sprintDTO) {
        return sprintService.addSprint(sprintDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public SprintDTO updateSprint(@PathVariable Long id, @RequestBody SprintDTO sprintDTO) {
        return sprintService.updateSprint(id, sprintDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public SprintDTO getSprintInfo(@PathVariable Long id) {
        return sprintService.getSprintInfo(id);
    }

}
