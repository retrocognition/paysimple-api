package com.retro.paysimple.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * this class exists as a workaround for the spring configuration. we cannot easily
 * call the <tt>registerModule</tt> method, so we do it here
 * @author mark
 */
public class ObjectMapperImpl extends ObjectMapper {
    // serializable
    private static final long serialVersionUID = -2509869857818449802L;

    public ObjectMapperImpl() {
        // call the super
        super();
        // register the necessary modules
        this.registerModule(new JodaModule());
    }
}
