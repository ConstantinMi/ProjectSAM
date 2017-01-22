package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by Claudiu on 1/12/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FeatureNotFoundException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = 3043030323399517457L;

    public FeatureNotFoundException(String message) {
        super(message);
    }
}
