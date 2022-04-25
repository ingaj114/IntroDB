package com.company.objects;

import java.util.*;

public class Books {
    private int id;
    private String name;
    private List<Price> price;

    public Books(int id, String name, List<Price> price) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Books(List<Price> price) {
        this.price = price;
    }
}
