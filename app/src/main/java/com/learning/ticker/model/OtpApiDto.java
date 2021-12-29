package com.learning.ticker.model;

import java.util.List;

public class OtpApiDto {
    String errorCode;
    List<OtpDto> response;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<OtpDto> getResponse() {
        return response;
    }

    public void setResponse(List<OtpDto> response) {
        this.response = response;
    }
}
