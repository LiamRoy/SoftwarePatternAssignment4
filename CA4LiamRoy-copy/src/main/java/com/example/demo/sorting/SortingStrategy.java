package com.example.demo.sorting;

import java.util.ArrayList;

import com.example.demo.entities.Stock;

//Strategy Pattern
public interface SortingStrategy {

    public ArrayList<Stock> sortAsc(ArrayList<Stock> products);
    public ArrayList<Stock> sortDesc(ArrayList<Stock> products);


}