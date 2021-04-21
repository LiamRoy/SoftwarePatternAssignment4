package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.entities.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.StockDto;

@Service
public class StockServiceImpl {
	
	List<Stock> stockItems;
	private StockRepository StockRepo;
	
	public StockServiceImpl(StockRepository StockRepo) {
		super();
		this.StockRepo = StockRepo;
	}
	
	public Stock save(StockDto stockDto) {
		// TODO Auto-generated method stub
		
		Stock stock = new Stock(stockDto.getTitle(),
				stockDto.getManufacturer(),
				stockDto.getPrice(),stockDto.getCategory(),stockDto.getProductImageLink(),stockDto.getQuantity());
		return StockRepo.save(stock);
	}
	
	 public Stock findById(int stockId) {
	        return StockRepo.findById(stockId);
	    }
	 
	 public Stock FindByTitle(String title) {
		 return StockRepo.findByTitle(title);
	 }
	
	public List<Stock> showAllStock() {
        stockItems = new ArrayList<Stock>();
        for (Stock stockItem : StockRepo.findAll()) {
            stockItems.add(stockItem);
        }

        return stockItems;
    }

	public void delete(Stock findById) {
		// TODO Auto-generated method stub
		
	}

}
