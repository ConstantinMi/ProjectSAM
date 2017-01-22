package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Claudiu on 1/11/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2786475107881951342L;

    public ProjectNotFoundException(String message) {
        super(message);
    }

}
