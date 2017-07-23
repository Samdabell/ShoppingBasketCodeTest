package com.example.sam.shoppingbasketcodetest;

/**
 * Created by Sam on 22/07/2017.
 */

public class Customer {
    private String name;
    private boolean loyal;

    public Customer(String name, boolean loyal) {
        this.name = name;
        this.loyal = loyal;
    }

    public String getName() {
        return name;
    }


    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }
}
