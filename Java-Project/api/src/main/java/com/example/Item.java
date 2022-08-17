package com.example;

public class Item {
    private int id;
    private String title;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int compare(Item a, Item b) {
        return a.price - b.price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Id: ").append(id).append(", ")
                .append("Title: ").append(title).append(", ")
                .append("Price: ").append(price).append(", ");
        return builder.toString();
    }
}