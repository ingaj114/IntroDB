package com.company.objects;

import com.company.Main;

import java.util.Collections;
import java.util.List;

public class Books {
    private int id;
    private String name;
    private List<Price> price;

    public Books(int id, String name, List<Price> price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;

    }
}
