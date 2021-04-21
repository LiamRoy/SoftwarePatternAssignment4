package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CartItem;
import com.example.demo.entities.Order;
import com.example.demo.entities.Stock;
import com.example.demo.entities.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.CartDto;
import com.example.demo.web.dto.StockDto;



@Service
public class OrderServiceImpl implements OrderService
{
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    List<CartItem> cartItems;
    @Autowired
    protected UserRepository usersRepository;

    @Autowired
    protected OrderRepository ordersRepository;

    @Autowired
    protected StockRepository productsRepository;
    
    @Autowired CartRepository cartRepo;
    
    public OrderServiceImpl(CartRepository cartRepo) {
		super();
		this.cartRepo = cartRepo;
	}

    private User getAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return usersRepository.findByUsername(username);
    }

    public List<Order> getOrders() {
        return ordersRepository.findByUser(getAuthUser());
    }

    public String getOrderTotalCost(int orderId) {
        Order order = ordersRepository.findById(orderId);
        if (order != null) {
            int totalCost = 0;
            for (Stock product: order.getProducts()) {
                double price = product.getPrice();
                totalCost += price;
            }
            return Integer.toString(totalCost);
        }

        return "";
    }

    public Order addNewCart() {
        User user = getAuthUser();
        Date date = new Date();
        Order cart = new Order(user, sdf.format(date), "cart");
        ordersRepository.save(cart);
        return cart;
    }

    public Order getCart() {
        User user = getAuthUser();
        List<Order> orders = ordersRepository.findByStatusAndUser("cart", user);
        if (orders.size() > 0) {
            Order cart = orders.get(0);
            return cart;
        }

        return addNewCart();
    }
    public CartItem save(CartDto cartDto) {
    	CartItem cart = new CartItem(cartDto.getItem(),cartDto.getQuantity());
    	return cartRepo.save(cart);
    }
    
    public List<CartItem> showAllCart() {
        cartItems = new ArrayList<CartItem>();
        for (CartItem cartItem : cartRepo.findAll()) {
            cartItems.add(cartItem);
        }
        return cartItems;
    }
	
    public void addToCart(int productId) {    	
        Optional<Stock> queryResult = Optional.ofNullable(productsRepository.findById(productId));
        if (queryResult.isPresent()) {
        	Stock product = queryResult.get();
            Order cart = getCart();
            Set<Stock> productsInCart = cart.getProducts();
            Boolean alreadyInCart = false;
            for (Stock item: productsInCart ) {
                if (item.getId() == productId) {
                    alreadyInCart = true;
                }
            }
            if (!alreadyInCart) {
                productsInCart.add(product);
                product.getOrders().add(cart);
                ordersRepository.save(cart);
                productsRepository.save(product);
            }
        }
    }

    public void removeFromCart(int productId) {
        Optional<Stock> queryResult = Optional.ofNullable(productsRepository.findById(productId));
        if (queryResult.isPresent()) {
        	Stock product = queryResult.get();
            Order cart = getCart();
            product.getOrders().removeIf(order -> order.getId() == cart.getId());
            cart.getProducts().removeIf(prod -> prod.getId() == productId);
            ordersRepository.save(cart);
            productsRepository.save(product);
        }
    }

    public Set<Stock> getCartContent() {
        Order cart = getCart();
        Set<Stock> productsInCart = cart.getProducts();
        return productsInCart;
    }

    public int getCartSize() {
        return getCartContent().size();
    }

    public String getTotalCartPrice() {
        Set<Stock> productsInCart = getCartContent();
        int totalPrice = 0;
        for (Stock product: productsInCart) {
            double price = product.getPrice();
            totalPrice += price;
        }
        return Integer.toString(totalPrice);
    }

    public void clearCartContent() {
        Order cart = getCart();
        Set<Stock> productsInCart = cart.getProducts();
        for (Stock product: productsInCart) {
            product.getOrders().removeIf(order -> order.getId() == cart.getId());
            productsRepository.save(product);
        }
        cart.getProducts().clear();
        ordersRepository.save(cart);
    }

    public void cartToOrder() {
        User user = getAuthUser();
        List<Order> orders  = ordersRepository.findByStatusAndUser("cart", user);
        if (orders.size() > 0) {
            Order cart = orders.get(0);
            cart.setStatus("ordered");
            ordersRepository.save(cart);
        }
    }
}

