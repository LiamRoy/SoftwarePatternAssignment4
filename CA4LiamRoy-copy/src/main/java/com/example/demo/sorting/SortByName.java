package com.example.demo.sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.demo.entities.Stock;

public class SortByName implements SortingStrategy{
    @Override
    public ArrayList<Stock> sortAsc(ArrayList<Stock> products) {
        Collections.sort(products, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));

        return products;
    }

    @Override
    public ArrayList<Stock> sortDesc(ArrayList<Stock> products) {
        Collections.sort(products, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        Collections.reverse(products);

        return products;
    }
}
