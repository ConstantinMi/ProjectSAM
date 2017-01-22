package ro.uaic.feaa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by Claudiu on 1/10/2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ActiveSprintException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 2857337568400388879L;

    public ActiveSprintException(String message) {
        super(message);
    }
}
