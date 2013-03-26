package com.retro.paysimple.connector.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.retro.paysimple.BaseTestImpl;
import com.retro.paysimple.core.Customer;

public class CustomerResponseTest extends BaseTestImpl {

    @Test
    public final void testJsonDeSerialize() throws JsonParseException, JsonMappingException, IOException {
        // create the new object mapper
        BasicResponse<Customer> response = getObjectMapper().readValue(new File("src/test/java/com/retro/paysimple/connector/response/new.customer.response.1.json"),CustomerResponse.class);
        
        // verify meta data
        assertEquals("Created",response.getMeta().getHttpStatus());
        assertEquals(Integer.valueOf(201),response.getMeta().getHttpStatusCode());
        // verify the customer
        assertEquals(Long.valueOf(2087241),response.getResponse().getId());
        assertEquals("Tom",response.getResponse().getFirstName());
        assertEquals("Simple",response.getResponse().getLastName());
        assertEquals("tsimple@paysimple.com",response.getResponse().getEmail());
        assertEquals(DateTime.parse("2012-06-28T15:42:41.5152506Z"),response.getResponse().getCreated());
        assertEquals(DateTime.parse("2012-06-28T15:42:41.5152506Z"),response.getResponse().getUpdated());
        assertTrue(response.getResponse().getShippingSameAsBilling());
        
//        // verify
//        // billing
//        assertEquals("123 Simple Street",customer.getBillingAddress().getStreetAddress1());
//        assertNull(customer.getBillingAddress().getStreetAddress2());
//        assertEquals("Denver",customer.getBillingAddress().getCity());
//        assertEquals("CO",customer.getBillingAddress().getStateCode());
//        assertEquals("80202",customer.getBillingAddress().getZipCode());
//        assertEquals("US",customer.getBillingAddress().getCountry());
//        // shipping
//        assertEquals("123 Simple Street",customer.getShippingAddress().getStreetAddress1());
//        assertNull(customer.getShippingAddress().getStreetAddress2());
//        assertEquals("Denver",customer.getShippingAddress().getCity());
//        assertEquals("CO",customer.getShippingAddress().getStateCode());
//        assertEquals("80202",customer.getShippingAddress().getZipCode());
//        assertEquals("US",customer.getShippingAddress().getCountry());
//        // other stuff
//        assertNull(customer.getCompany());
//        assertNull(customer.getNotes());
    }
}
