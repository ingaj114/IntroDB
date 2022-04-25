package com.company.objects;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Price> priceList = new ArrayList<>();
        priceList.add(new Price(10.78f));
        priceList.add(new Price(4.99f));
        priceList.add(new Price(3.9f));
        priceList.add(new Price(11f));
        priceList.add(new Price(3.89f));

        Books books = new Books(1, "Cilveka berns", priceList);
        Books books2 = new Books(2, "Aktrise Ragares", priceList);
        Books books3 = new Books(3, "Eksistencialisms", priceList);
        Books books4 = new Books(4, "Enpils", priceList);
        Books books5 = new Books(5, "Upe", priceList);

        System.out.println(books.getName());
        System.out.println(books4.getName());

    }
}
