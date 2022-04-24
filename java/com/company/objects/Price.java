package com.company.objects;

public class Price {
    private int id;
    private float price;

    public Price(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
