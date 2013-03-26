package com.retro.paysimple.connector.util;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;

public class SecurityUtil {
    final static Logger _log = LoggerFactory.getLogger(SecurityUtil.class);
    
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    
    /**
     * Add an Authorization Header to your request:
        a.  Create your API Signature
        Get UTC timestamp in ISO-8601 format
        Compute HMAC with date and shared secret, both encoded UTF8, using SHA256 hashing algorithm
        Base-64 Encode the HMAC
        b. Concatenate "accessid=" + your API Username + "; timestamp=" + the ISO-8601 timestamp defined in step a + "; signature=" + the HMAC result of step a.
        c.  Include in the authorization header in the following format: ÒPSSERVERÓ + Ò Ò + the result of step b.
        Example: ÒAuthorization: PSSERVER accessid=APIUser1000; timestamp=2012-07-20T20:45:44.0973928Z; signature=WqV47Dddgc6XqBKnQASzZbNU/UZd1tzSrFJJFVv76dw=Ó
        Call any endpoint with API URI
     * @return
     * @throws SignatureException 
     * @throws UnsupportedEncodingException 
     */
    public static String generatePaySimpleAuthorization(String accessId,String secret) throws SignatureException, UnsupportedEncodingException {
        // get the current time
        String now = DateTime.now().toString();
        _log.debug("current time is [{}]",now);
        byte[] hexBytes;
        try {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(),HMAC_ALGORITHM);
            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            mac.init(signingKey);
            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(now.getBytes());
            // base64-encode the hmac
            hexBytes = Base64.encode(rawHmac);
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        // build the result
        return new StringBuilder("PSSERVER accessid=")
            .append(accessId)
            .append("; timestamp=")
            .append(now)
            .append("; signature=")
            .append(new String(hexBytes,"UTF-8"))
            .toString();
    }
}
