package com.example.sam.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Sam on 22/07/2017.
 */

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Sam", true);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Sam", customer.getName());
    }

    @Test
    public void testHasLoyaltyCard() throws Exception {
        assertTrue(customer.isLoyal());
    }

    @Test
    public void testSetLoyalty() throws Exception {
        customer.setLoyal(false);
        assertFalse(customer.isLoyal());
    }
}
