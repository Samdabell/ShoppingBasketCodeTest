package com.example.sam.shoppingbasketcodetest;

/**
 * Created by Sam on 22/07/2017.
 */

public class Item {
    private boolean checked;
    private boolean bogof;
    private int price;
    private String name;

    public Item(String name, int price, boolean bogof) {
        this.name = name;
        this.price = price;
        this.bogof = bogof;
        checked = false;
    }

    public boolean isBogof() {
        return bogof;
    }

    public void setBogof(boolean bogof) {
        this.bogof = bogof;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
