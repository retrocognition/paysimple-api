package com.retro.paysimple.connector.response;

abstract class BasicResponse <T> {
    private ResponseMeta meta;
    private T response;
    
    public ResponseMeta getMeta() {
        return meta;
    }
    public void setMeta(ResponseMeta meta) {
        this.meta = meta;
    }
    public T getResponse() {
        return response;
    }
    public void setResponse(T response) {
        this.response = response;
    }
}
