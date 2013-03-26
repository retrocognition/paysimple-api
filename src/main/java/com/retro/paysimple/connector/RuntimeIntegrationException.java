package com.retro.paysimple.connector;

public class RuntimeIntegrationException extends RuntimeException {

	private static final long serialVersionUID = 496065956760649576L;

	public RuntimeIntegrationException(String message) {
        super(message);
    }
    
    public RuntimeIntegrationException(String message,Exception e) {
        super(message,e);
    }

    public RuntimeIntegrationException(Exception e) {
        super(e);
    }
}
