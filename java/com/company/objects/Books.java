package com.company.objects;

public class Books {

    private int id;
    private String name;
    private int price;

    public Books(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Books() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

