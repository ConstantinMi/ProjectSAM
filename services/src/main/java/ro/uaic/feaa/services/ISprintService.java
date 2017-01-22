package ro.uaic.feaa.services;

import ro.uaic.feaa.dto.SprintDTO;
import ro.uaic.feaa.exceptions.ActiveSprintException;

/**
 * Created by Claudiu on 1/10/2017.
 */
public interface ISprintService {

    SprintDTO addSprint(SprintDTO sprintDTO);

    SprintDTO updateSprint(Long sprintId, SprintDTO sprintDTO);

    SprintDTO getSprintInfo(Long sprintId);

}
