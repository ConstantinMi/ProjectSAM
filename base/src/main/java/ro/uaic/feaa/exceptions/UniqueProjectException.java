package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Claudiu on 1/11/2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UniqueProjectException extends RuntimeException {

    private static final long serialVersionUID = 6056746335919965250L;

    public UniqueProjectException(String message) {
        super(message);
    }
}
