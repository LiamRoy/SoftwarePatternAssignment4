package com.example.demo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.demo.entities.Stock;

public class SortByManufacturer implements  SortingStrategy {
    @Override
    public ArrayList<Stock> sortAsc(ArrayList<Stock> products) {
        Collections.sort(products, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));



        return products;
    }

    @Override
    public ArrayList<Stock> sortDesc(ArrayList<Stock> products) {
        Collections.sort(products, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
        Collections.reverse(products);


        return products;
    }
}
