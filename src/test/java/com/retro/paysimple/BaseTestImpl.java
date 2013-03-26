package com.retro.paysimple;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class BaseTestImpl {
    // logging
    final static Logger _log = LoggerFactory.getLogger(BaseTestImpl.class);
    private static ApplicationContext ctx = null;
    
    // generate a random number
    public static String rand = RandomStringUtils.randomAlphanumeric(8);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        _log.info("spinning up spring context");
        // init spring
        ctx = new ClassPathXmlApplicationContext(new String[] {"com/retro/paysimple/paysimple-client.xml"});
    }
    
    public ObjectMapper getObjectMapper() {
        return getCtx().getBean("objectMapper",ObjectMapper.class);
    }
    
    public ApplicationContext getCtx() {
        return ctx;
    }

    public static String getRand() {
        return rand;
    }

    public static void setRand(String rand) {
        BaseTestImpl.rand = rand;
    }

}
