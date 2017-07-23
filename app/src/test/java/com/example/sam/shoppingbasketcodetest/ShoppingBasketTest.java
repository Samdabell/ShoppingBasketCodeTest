package com.example.sam.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Sam on 22/07/2017.
 */

public class ShoppingBasketTest {

    private Customer customer1;
    private Customer customer2;
    private Item item1;
    private Item item2;
    private Item item3;
    private ShoppingBasket basket1;
    private ShoppingBasket basket2;

    @Before
    public void setUp() throws Exception {
        customer1 = new Customer("Sam", true);
        customer2 = new Customer("Freyja", false);
        item1 = new Item("Milk", 1, true);
        item2 = new Item("Beer", 4, false);
        item3 = new Item("Cheese", 3, true);
        basket1 = new ShoppingBasket(customer1);
        basket2 = new ShoppingBasket(customer2);
    }

    @Test
    public void testNoItemCount() throws Exception {
        assertEquals(0, basket1.numItems());
    }

    @Test
    public void testAddItem() throws Exception {
        basket1.add(item1);
        assertEquals(1, basket1.numItems());
    }

    @Test
    public void testRemoveItem() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.remove(item1);
        assertEquals(1, basket1.numItems());
    }

    @Test
    public void testEmptyBasket() throws Exception {
        basket1.add(item1);
        basket1.add(item2);
        basket1.empty();
        assertEquals(0, basket1.numItems());
    }

    @Test
    public void testGetBasicTotal() throws Exception {
        basket1.add(item2);
        assertEquals(4.0, basket1.getTotal());
    }

    @Test
    public void testOver20Discount() throws Exception {
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        basket1.over20Check();
        assertEquals(21.60, basket1.getTotal());
    }

    @Test
    public void testLoyaltyDiscount() throws Exception {
        basket1.add(item1);
        basket1.loyaltyCheck();
        assertEquals(0.98, basket1.getTotal());
    }

    @Test
    public void testNotLoyalUnder20() throws Exception {
        basket2.add(item1);
        basket2.over20Check();
        basket2.loyaltyCheck();
        assertEquals(1.0, basket2.getTotal());
    }

    @Test
    public void testBOGOF() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item2);
        basket1.bogofCheck();
        assertEquals(5.0, basket1.getTotal());
    }

    @Test
    public void test3BogofItems() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.bogofCheck();
        assertEquals(2.0, basket1.getTotal());
    }

    @Test
    public void test4BogofItems() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.bogofCheck();
        assertEquals(2.0, basket1.getTotal());
    }

    @Test
    public void test5BogofItems() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.bogofCheck();
        assertEquals(3.0, basket1.getTotal());
    }

    @Test
    public void testMultipleBogofItems() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item2);
        basket1.add(item3);
        basket1.add(item3);
        basket1.bogofCheck();
        assertEquals(8.0, basket1.getTotal());
    }

    @Test
    public void testAllDiscountsIsLoyal() throws Exception {
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item1);
        basket1.add(item3);
        basket1.add(item3);
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        basket1.add(item2);
        assertEquals(22.05, basket1.total());
    }

    @Test
    public void testAllDiscountsNotLoyal() throws Exception {
        basket2.add(item1);
        basket2.add(item1);
        basket2.add(item1);
        basket2.add(item1);
        basket2.add(item3);
        basket2.add(item3);
        basket2.add(item2);
        basket2.add(item2);
        basket2.add(item2);
        basket2.add(item2);
        basket2.add(item2);
        assertEquals(22.5, basket2.total());
    }
}
