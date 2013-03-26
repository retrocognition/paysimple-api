package com.retro.paysimple.connector.util;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.junit.Test;

public class SecurityUtilTest {

    @Test
    public final void testAuthorization() throws SignatureException, UnsupportedEncodingException {
        String key = SecurityUtil.generatePaySimpleAuthorization("APIUser103381","FHYoLOWnXpkn8aHfc0tRpxiJ7v2ygAo7jDpFRiKzuYzXvzuTsMiaQGRtoyEfLIexowesePSBZPVeUDpWmfaVHiAlRIm2gjm68Z3hngEIj0VFCdvwUCvwdrhpInwkEbZ0");
        System.out.println("key is " + key);
    }

}
