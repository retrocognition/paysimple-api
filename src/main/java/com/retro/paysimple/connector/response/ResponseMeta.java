package com.retro.paysimple.connector.response;


public class ResponseMeta {
    private String errors;
    private String httpStatus;
    private Integer httpStatusCode;
    private PagingDetails pagingDetails;
    
    public String getErrors() {
        return errors;
    }
    public void setErrors(String errors) {
        this.errors = errors;
    }
    public String getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
    public PagingDetails getPagingDetails() {
        return pagingDetails;
    }
    public void setPagingDetails(PagingDetails pagingDetails) {
        this.pagingDetails = pagingDetails;
    }
}
