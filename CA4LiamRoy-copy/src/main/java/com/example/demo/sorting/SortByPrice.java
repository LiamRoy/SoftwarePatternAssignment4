package com.example.demo.sorting;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.demo.entities.Stock;

 class SortByPrice implements SortingStrategy {

    @Override
    public ArrayList<Stock> sortAsc(ArrayList<Stock> products) {
        Collections.sort(products, new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        return products;
    }

    @Override
    public ArrayList<Stock> sortDesc(ArrayList<Stock> products) {
        Collections.sort(products, new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        Collections.reverse(products);


        return products;
    }
}
