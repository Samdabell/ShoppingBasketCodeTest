package com.example.sam.shoppingbasketcodetest;

import java.util.ArrayList;

/**
 * Created by Sam on 22/07/2017.
 */

public class ShoppingBasket {
    private Customer customer;
    private ArrayList<Item> items;
    private double total;

    public ShoppingBasket(Customer customer) {
        this.customer = customer;
        items = new ArrayList<Item>();
    }

    public int numItems() {
        return items.size();
    }

    public void add(Item item) {
        items.add(item);
        total += item.getPrice();
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public void empty() {
        items.clear();
    }

    public double getTotal() {
        return total;
    }

    public void over20Check() {
        if (total > 20){
            total *= 0.9;
        }
    }

    public void loyaltyCheck() {
        if (customer.isLoyal()){
            total *= 0.98;
        }
    }

    public void bogofCheck() {
        for (Item item : items){
            if (item.isBogof() && !item.isChecked()){
                int counter = 0;
                for (Item item1 : items){
                    if (item1.getName().equals(item.getName()) && !item1.isChecked()){
                        counter ++;
                    }
                }
                int discountTotal = item.getPrice() * counter/2;
                total -= discountTotal;
                item.setChecked(true);
            }
        }
    }

    public double total() {
        bogofCheck();
        over20Check();
        loyaltyCheck();
        return getTotal();
    }
}
