package com.example.demo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.demo.entities.Stock;

import java.util.ArrayList;
import java.util.Collections;

public class SortByCategory implements SortingStrategy {


    @Override
    public ArrayList<Stock> sortAsc(ArrayList<Stock> products) {
        Collections.sort(products, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));


        return products;
    }

    @Override
    public ArrayList<Stock> sortDesc(ArrayList<Stock> products) {
        Collections.sort(products, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));
        Collections.reverse(products);


        return products;
    }
}