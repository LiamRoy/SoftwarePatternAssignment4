package com.example.demo.sorting;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.demo.entities.Stock;

public class SortByQuantity implements SortingStrategy {
    @Override
    public ArrayList<Stock> sortAsc(ArrayList<Stock> products) {
        Collections.sort(products, new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
              return   o1.getQuantity() - o2.getQuantity();
            }
        });
        return products;
        }

    @Override
    public ArrayList<Stock> sortDesc(ArrayList<Stock> products) {
        Collections.sort(products, new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return   o1.getQuantity() - o2.getQuantity();
            }
        });
       Collections.reverse(products);
       return products;
    }
}
