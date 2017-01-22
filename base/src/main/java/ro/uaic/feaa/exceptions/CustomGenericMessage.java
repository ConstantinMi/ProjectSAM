package ro.uaic.feaa.exceptions;

/**
 * Created by Claudiu on 1/10/2017.
 */
public class CustomGenericMessage {

    private Long errCode;
    private String httpStatus;
    private String errMsg;

    public CustomGenericMessage(Long errCode, String httpStatus, String errMsg) {
        this.errCode = errCode;
        this.httpStatus = httpStatus;
        this.errMsg = errMsg;
    }

    public Long getErrCode() {
        return errCode;
    }

    public void setErrCode(Long errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
