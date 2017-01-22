package ro.uaic.feaa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.dto.UsersDTO;
import ro.uaic.feaa.exceptions.ProjectNotFoundException;
import ro.uaic.feaa.exceptions.UniqueProjectException;
import ro.uaic.feaa.models.Project;
import ro.uaic.feaa.models.Users;
import ro.uaic.feaa.services.IProjectService;
import ro.uaic.feaa.services.utils.ProjectUserUtils;
import ro.uaic.feaa.services.utils.ProjectUtils;
import ro.uaic.feaa.storage.IProjectDAO;
import ro.uaic.feaa.storage.IUsersDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Claudiu on 1/11/2017.
 */
@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IUsersDAO usersDAO;

    @Autowired
    private IProjectDAO projectDAO;

    @Autowired
    private ProjectUserUtils projectUserUtils;

    @Override
    public List<ProjectDTO> getProjects() {
        return projectDAO.findAll(null)
                .stream()
                .map(ProjectUtils::fromModelToDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO addProject(ProjectDTO projectDTO) {

        Optional<Project> existingProject = projectDAO.findByName(projectDTO.getProjectName());
        if (!existingProject.isPresent()) {
            Project project = ProjectUtils.fromDtoToModel(projectDTO);
            project = projectDAO.createNew(project);

            return ProjectUtils.fromModelToDTO(project);
        } else
            throw new UniqueProjectException("There is already a project with the same name");
    }

    @Override
    public void deleteProject(Long projectId) {
        projectDAO.delete(projectId);
    }

    @Override
    public List<UsersDTO> getUsersFromProject(String projectName) {
        Optional<Project> existingProject = projectDAO.findByName(projectName);

        if (existingProject.isPresent()) {
            return projectUserUtils.getUsersDTOByIds(usersDAO.findUsersByProjectId(existingProject.get().getId()));
        } else
            throw new ProjectNotFoundException("No project found with the specified name");
    }

    @Override
    public void addUserToProject(String username, String projectName) {
        Optional<Users> existingUser = usersDAO.findByUsername(username);
        Optional<Project> existingProject = projectDAO.findByName(projectName);

        if (existingProject.isPresent() && existingUser.isPresent()) {
            existingUser.get().getProjects().add(existingProject.get());
            usersDAO.update(existingUser.get());

        }
        if (!existingProject.isPresent())
            throw new ProjectNotFoundException("No project found with the specified name");
    }

    @Override
    public ProjectDTO getProject(String projectName) {
        Optional<Project> existingProject = projectDAO.findByName(projectName);

        if (existingProject.isPresent()) {
            return ProjectUtils.fromModelToDTO(existingProject.get());
        } else
            throw new ProjectNotFoundException("No project found with the specified name");
    }
}
