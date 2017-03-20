package ro.uaic.feaa.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.models.Project;
import ro.uaic.feaa.services.utils.ProjectUserUtils;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by Claudiu on 1/25/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceImplTest {

    private UserServiceImpl userService;
    private ProjectServiceImpl projectService;
    private ProjectUserUtils projectUserUtils;

    private ProjectDTO projectDTO;
    private ProjectDTO projectDTO1;

    @Before
    public void setUp() {
        userService = spy(new UserServiceImpl());
        projectService = spy(new ProjectServiceImpl());
        projectUserUtils = spy(new ProjectUserUtils());

        projectDTO = setUpProject(projectDTO);
        projectDTO1 = setUpProjectAfterCreate(projectDTO1);
    }

    @Test
    public void addProject() {
        doReturn(projectDTO1).when(projectService).addProject(projectDTO);
        ProjectDTO project = projectService.addProject(projectDTO);

        assertNotNull(project);
        assertEquals(project.getProjectName(), projectDTO.getProjectName());
    }

    @Test
    public void getProject() {
        doReturn(projectDTO1).when(projectService).getProject(projectDTO.getProjectName());
        ProjectDTO project = projectService.getProject(projectDTO.getProjectName());

        assertNotNull(project);
    }

    private ProjectDTO setUpProject(ProjectDTO projectDTO) {
        projectDTO = new ProjectDTO();
        projectDTO.setProjectName("Proiect Nou");

        return projectDTO;
    }

    private ProjectDTO setUpProjectAfterCreate(ProjectDTO projectDTO) {
        projectDTO = setUpProject(projectDTO);
        projectDTO.setId(1L);

        return projectDTO;
    }

}