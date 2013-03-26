package com.retro.paysimple.connector;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.retro.paysimple.connector.response.CustomerResponse;
import com.retro.paysimple.core.Customer;

public class CustomerConnector extends BaseConnector {
    // logging
    private final Logger _log = LoggerFactory.getLogger(CustomerConnector.class);
    
    /**
     * UriComponents uriComponents = 
        UriComponentsBuilder.fromUriString("http://example.com/hotels/{hotel}/bookings/{booking}").build()
            .expand("42", "21")
            .encode();
            
URI uri = uriComponents.toUri();

     * @return
     */
    public CustomerResponse createCustomer(Customer customer) {
        
        getRestTemplate().setErrorHandler(new ResponseErrorHandler() {
            
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                _log.error("has error is [{}]",response.getRawStatusCode());
                return false;
            }
            
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                // TODO Auto-generated method stub
                _log.error("handle error is [{}]",response.getStatusText());
            }
        });
        
        _log.info("creating new customer with [{}]",customer);
        return getRestTemplate().postForObject("https://sandbox-api.paysimple.com/v4/customer",customer,CustomerResponse.class);
    }
}
