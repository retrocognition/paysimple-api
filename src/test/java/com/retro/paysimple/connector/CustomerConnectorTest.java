package com.retro.paysimple.connector;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.retro.paysimple.BaseTestImpl;
import com.retro.paysimple.connector.response.CustomerResponse;
import com.retro.paysimple.core.Customer;

public class CustomerConnectorTest extends BaseTestImpl {

    @Test
    public final void testCreateCustomer() {
        // get the customer connector
        CustomerConnector connector = getCtx().getBean("customerConnector",CustomerConnector.class);
        // create the test customer
        Customer customer = new Customer();
        customer.setFirstName("Austin");
        customer.setMiddleName("Danger");
        customer.setLastName("Powers");
        // try to create it
        CustomerResponse response = connector.createCustomer(customer);
        assertEquals("Austin",response.getResponse().getFirstName());
        assertEquals("Danger",response.getResponse().getMiddleName());
        assertEquals("Powers",response.getResponse().getLastName());
    }

}
