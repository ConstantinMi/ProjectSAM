package ro.uaic.feaa.services;

import ro.uaic.feaa.dto.FeatureDTO;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.dto.UsersDTO;

import java.util.List;

/**
 * Created by Claudiu on 12/26/2016.
 */
public interface IProjectService {

    List<ProjectDTO> getProjects();

    ProjectDTO addProject(ProjectDTO projectDTO);

    void deleteProject(Long projectId);

    List<UsersDTO> getUsersFromProject(String projectName);

    void addUserToProject(String username, String projectName);

    ProjectDTO getProject(String projectName);

    List<FeatureDTO> getProjectsFeatures(String projectName);
}
