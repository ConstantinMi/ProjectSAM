package ro.uaic.feaa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.models.Project;
import ro.uaic.feaa.services.IProjectService;

import java.util.List;

/**
 * Created by Claudiu on 1/11/2017.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @RequestMapping(path = "/{projectName}", method = RequestMethod.GET)
    public ProjectDTO getProject(@PathVariable String projectName) {
        return projectService.getProject(projectName);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectDTO> getProjects() {
        return projectService.getProjects();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProjectDTO addProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.addProject(projectDTO);
    }

    @RequestMapping(path = "/{projectName}/users", method = RequestMethod.GET)
    public List<UsersDTO> getUsersFromProject(@PathVariable String projectName) {
        return projectService.getUsersFromProject(projectName);
    }

    @RequestMapping(path = "/{projectName}/users", method = RequestMethod.POST)
    public void addUserToProject(@PathVariable String projectName, @RequestBody String username) {
        projectService.addUserToProject(username, projectName);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

}
