package com.example;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private List<Item> products;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return products;
    }

    public void setItems(List<Item> products) {
        this.products = products;
    }
}
