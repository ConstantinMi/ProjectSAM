package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by Claudiu on 1/22/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubFeatureNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 4793661335138516924L;

    public SubFeatureNotFoundException(String message) {
        super(message);
    }
}
