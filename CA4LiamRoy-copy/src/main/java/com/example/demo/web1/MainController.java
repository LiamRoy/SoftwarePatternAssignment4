package com.example.demo.web1;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.Transient;
import java.util.*;

import com.example.demo.entities.Administrator;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Stock;
import com.example.demo.repository.AdministratorRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrderServiceImpl;
import com.example.demo.service.StockServiceImpl;
import com.example.demo.service.UserService;

@Controller
public class MainController {
	
	private StockServiceImpl stockService;
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private UserService userService;
    
    private OrderServiceImpl orderService;
		
	public MainController(StockServiceImpl stockService) {
		super();
		this.stockService = stockService;
		this.orderService = orderService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "adminLogin";
	}
	
	//GET Request not working
	/*@PostMapping("/addAdmin")
    public @ResponseBody
    String addNewCustomer(@RequestParam String username, @RequestParam String password) {
        Administrator administrator = new Administrator("admin", "password");
        administratorRepository.save(administrator);
        return "index";
    }*/
	
	//DELETE FUNCTION NOT WORKING
	/*@RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "title") String title) {
        stockService.delete(stockService.findById(title));
        return "welcome";
    }*/	
	
	@GetMapping(path = "/stockList")
    public String getAll(HttpServletRequest request) {
        Iterable<Stock> getAllStocks = stockService.showAllStock();
        request.setAttribute("Items", getAllStocks);
        request.setAttribute("mode", "STORE_ITEMS");
        
        Iterable<Stock> stock = stockService.showAllStock();
		for(Stock s : stock) {
			System.out.println("------------");
			System.out.println("Stock title: "+s.getTitle());
			System.out.println("Stock manufacturer: "+s.getManufacturer());
			System.out.println("Stock category: "+s.getCategory());
			System.out.println("Stock price: "+s.getPrice());
			System.out.println("Stock image: "+s.getProductImageLink());
			System.out.println("Stock quantity: "+s.getQuantity());			
		}
		
        return "stockList";
    }
	
	@GetMapping(path = "/cartList")
	public String getCart(HttpServletRequest request) {
		Iterable<CartItem> cart = orderService.showAllCart();
		for(CartItem c: cart) {
			System.out.println("------------");
			System.out.println("Items in Cart: ");
			System.out.println("Item title: "+c.getItem());
			System.out.println("Item quantity: "+c.getQuantity());		
		}
		return "index";
	}
}