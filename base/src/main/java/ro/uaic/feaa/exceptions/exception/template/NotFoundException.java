package ro.uaic.feaa.exceptions.exception.template;

import org.springframework.stereotype.Component;

/**
 * Created by Claudiu on 1/11/2017.
 */
@Component
public class NotFoundException implements GenericException {

    @Override
    public Long getErrorCode() {
        return 404L;
    }

    @Override
    public String getErrorStatus() {
        return "Not found";
    }

}
