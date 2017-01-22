package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by Claudiu on 1/12/2017.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UniqueFeatureException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 173509575569129486L;

    public UniqueFeatureException(String message) {
        super(message);
    }
}
