package com.retro.paysimple.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class BaseConnector {
    // logging
    private final Logger _log = LoggerFactory.getLogger(BaseConnector.class);
    
    // spring rest template
    private RestTemplate restTemplate;
    

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
