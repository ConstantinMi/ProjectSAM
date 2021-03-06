package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by Claudiu on 1/12/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = -4809146994774998934L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
