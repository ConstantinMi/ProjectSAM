package ro.uaic.feaa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.uaic.feaa.exceptions.*;
import ro.uaic.feaa.exceptions.exception.template.BadRequestException;
import ro.uaic.feaa.exceptions.exception.template.NotFoundException;

/**
 * Created by Claudiu on 1/10/2017.
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ActiveSprintException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomGenericMessage handleActiveSprintEx(ActiveSprintException ex) {
        return new BadRequestException().handleException(ex);
    }

    @ExceptionHandler(SprintNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomGenericMessage handleSprintNotFoundEx(SprintNotFoundException ex) {
        return new NotFoundException().handleException(ex);
    }

    @ExceptionHandler(UniqueProjectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomGenericMessage handleUniqueProjectException(UniqueProjectException ex) {
        return new BadRequestException().handleException(ex);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomGenericMessage handleProjectNotFoundEx(ProjectNotFoundException ex) {
        return new NotFoundException().handleException(ex);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomGenericMessage handleUserNotFoundEx(UserNotFoundException ex) {
        return new NotFoundException().handleException(ex);
    }

    @ExceptionHandler(PersonalDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomGenericMessage handlePersonalDetailsNotFoundEx(PersonalDetailsNotFoundException ex) {
        return new NotFoundException().handleException(ex);
    }

    @ExceptionHandler(FeatureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomGenericMessage handleFeatureNotFoundEx(FeatureNotFoundException ex) {
        return new NotFoundException().handleException(ex);
    }

    @ExceptionHandler(SubFeatureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomGenericMessage handletSubFeatureNotFoundEx(SubFeatureNotFoundException ex) {
        return new NotFoundException().handleException(ex);
    }
}
