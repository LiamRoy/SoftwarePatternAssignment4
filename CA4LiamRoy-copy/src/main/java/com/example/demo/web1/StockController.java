package com.example.demo.web1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.StockServiceImpl;
import com.example.demo.web.dto.StockDto;

@Controller
@RequestMapping("/addStock")
public class StockController {

	private StockServiceImpl stockService;

	public StockController(StockServiceImpl stockService) {
		super();
		this.stockService = stockService;
	}
	
	@ModelAttribute("stock")
    public StockDto stockDto() {
        return new StockDto();
    }
	
	@GetMapping
	public String showStockForm() {
		return "addStock";
	}
	
	@PostMapping
	public String addStock(@ModelAttribute("stock") StockDto stockDto) {
		stockService.save(stockDto);
		return "index";
	}
}