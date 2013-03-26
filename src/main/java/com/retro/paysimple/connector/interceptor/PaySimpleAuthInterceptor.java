package com.retro.paysimple.connector.interceptor;

import java.io.IOException;
import java.security.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import com.retro.paysimple.connector.RuntimeIntegrationException;
import com.retro.paysimple.connector.util.SecurityUtil;

public class PaySimpleAuthInterceptor implements ClientHttpRequestInterceptor {
    // logging
    private final Logger _log = LoggerFactory.getLogger(PaySimpleAuthInterceptor.class);
    // creds
    private String accessId;
    private String sharedSecret;
    
    @Override
    public ClientHttpResponse intercept(HttpRequest request,byte[] body,ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
//        requestWrapper.getHeaders().setAccept(Arrays.asList(MediaType.valueOf("application/json")));
        requestWrapper.getHeaders().setContentType(MediaType.valueOf("application/json"));
        try {
            requestWrapper.getHeaders().add("Authorization",SecurityUtil.generatePaySimpleAuthorization(getAccessId(),getSharedSecret()));
        } catch (SignatureException e) {
            _log.error("error generating auth signature - [{}]",e);
            throw new RuntimeIntegrationException(e);
        }
//        ClientHttpResponse response = execution.execute(requestWrapper, body);
//        String content = CharStreams.toString(new InputStreamReader(response.getBody(),Charsets.UTF_8));
//        _log.info("response is {}",content);
        return execution.execute(requestWrapper, body);
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }
}
