package com.retro.paysimple.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;
import com.retro.paysimple.BaseTestImpl;

public class CustomerTest extends BaseTestImpl {
    
    @Test
    public final void testJsonDeSerialize() throws JsonParseException, JsonMappingException, IOException {
        // create the new object mapper
        Customer customer = getObjectMapper().readValue(new File("src/test/java/com/retro/paysimple/core/customer1.json"),Customer.class);
        // verify
        assertEquals(Long.valueOf(2087241),customer.getId());
        assertEquals("Tom",customer.getFirstName());
        assertEquals("Finn",customer.getMiddleName());
        assertEquals("Simple",customer.getLastName());
        assertEquals("tsimple@paysimple.com",customer.getEmail());
        assertEquals(DateTime.parse("2012-06-28T15:42:41.5152506Z"),customer.getCreated());
        assertEquals(DateTime.parse("2012-06-28T15:42:41.5152506Z"),customer.getUpdated());
        assertTrue(customer.getShippingSameAsBilling());
        // billing
        assertEquals("123 Simple Street",customer.getBillingAddress().getStreetAddress1());
        assertNull(customer.getBillingAddress().getStreetAddress2());
        assertEquals("Denver",customer.getBillingAddress().getCity());
        assertEquals("CO",customer.getBillingAddress().getStateCode());
        assertEquals("80202",customer.getBillingAddress().getZipCode());
        assertEquals("US",customer.getBillingAddress().getCountry());
        // shipping
        assertEquals("123 Simple Street",customer.getShippingAddress().getStreetAddress1());
        assertNull(customer.getShippingAddress().getStreetAddress2());
        assertEquals("Denver",customer.getShippingAddress().getCity());
        assertEquals("CO",customer.getShippingAddress().getStateCode());
        assertEquals("80202",customer.getShippingAddress().getZipCode());
        assertEquals("US",customer.getShippingAddress().getCountry());
        // other stuff
        assertNull(customer.getCompany());
        assertNull(customer.getNotes());
    }
    @Test
    public final void testJsonSerialize() throws JsonParseException, JsonMappingException, IOException {
        // create the new object mapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new PascalCaseStrategy());
        Customer customer = new Customer();
        customer.setFirstName("Austin");
        customer.setMiddleName("Danger");
        customer.setLastName("Powers");
        System.out.println(mapper.writeValueAsString(customer));
    }

}
