package ro.uaic.feaa.services.utils;

import org.springframework.stereotype.Component;
import ro.uaic.feaa.dto.ProjectDTO;
import ro.uaic.feaa.models.Project;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Claudiu on 1/11/2017.
 */
@Component
public class ProjectUtils {

    private static final String HYPHEN = "Hyphen";
    private static final String UNDERSCORE = "Underscore";
    private static final String SPACE = "Space";

    public static ProjectDTO fromModelToDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId(project.getId());
        projectDTO.setProjectName(project.getName());

        return projectDTO;
    }

    public static Project fromDtoToModel(ProjectDTO projectDTO) {
        Project project = new Project();

        project.setName(constructProjectName(projectDTO.getProjectName()));

        return project;
    }

    private static String constructProjectName(String projectName) {
        projectName = projectName.replaceAll("\\s", "_");

        return String.join("_", Arrays.stream(projectName.split("-|_")).map(s -> {
            s = s.substring(0,1).toUpperCase() + s.substring(1);
            return s;
        }).collect(Collectors.toList()));
    }
}
