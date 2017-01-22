package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Claudiu on 1/10/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SprintNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -2967052871653765980L;

    public SprintNotFoundException(String message) {
        super(message);
    }
}
