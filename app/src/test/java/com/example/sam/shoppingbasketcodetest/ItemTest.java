package com.example.sam.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Sam on 22/07/2017.
 */

public class ItemTest {

    Item item;
    Item item1;

    @Before
    public void setUp() throws Exception {
        item = new Item("Milk", 1, true);
        item1 = new Item("Beer", 4, false);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Milk", item.getName());
    }

    @Test
    public void testGetPrice() throws Exception {
        assertEquals(1, item.getPrice());
    }

    @Test
    public void testIsBogof() throws Exception {
        assertTrue(item.isBogof());
    }

    @Test
    public void testIsntBogof() throws Exception {
        assertFalse(item1.isBogof());
    }

    @Test
    public void testIfChecked() throws Exception {
        assertFalse(item.isChecked());
    }

    @Test
    public void testChangePrice() throws Exception {
        item.setPrice(2);
        assertEquals(2, item.getPrice());
    }

    @Test
    public void testMakeBogof() throws Exception {
        item1.setBogof(true);
        assertTrue(item1.isBogof());
    }

    @Test
    public void testSetChecked() throws Exception {
        item.setChecked(true);
        assertTrue(item.isChecked());
    }
}
