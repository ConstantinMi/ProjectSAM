package ro.uaic.feaa.exceptions.exception.template;

import org.springframework.stereotype.Component;

/**
 * Created by Claudiu on 1/11/2017.
 */
@Component
public class BadRequestException implements GenericException{

    @Override
    public Long getErrorCode() {
        return 400L;
    }

    @Override
    public String getErrorStatus() {
        return "Bad request";
    }
}
