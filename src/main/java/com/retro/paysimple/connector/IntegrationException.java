package com.retro.paysimple.connector;

public class IntegrationException extends Exception {

    private static final long serialVersionUID = 4602703440549580006L;

    public IntegrationException(String message) {
        super(message);
    }
    
    public IntegrationException(String message,Exception e) {
        super(message,e);
    }

    public IntegrationException(Exception e) {
        super(e);
    }
}
