package ro.uaic.feaa.exceptions.exception.template;

import ro.uaic.feaa.exceptions.CustomGenericMessage;

/**
 * Created by Claudiu on 1/11/2017.
 */
public interface GenericException {

    default  <T> CustomGenericMessage handleException(T ex) {
        return new CustomGenericMessage(getErrorCode(), getErrorStatus(), ((RuntimeException)ex).getMessage());
    }

    Long getErrorCode();

    String getErrorStatus();

}
