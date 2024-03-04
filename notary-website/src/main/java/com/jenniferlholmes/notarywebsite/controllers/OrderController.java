package com.jenniferlholmes.notarywebsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jenniferlholmes.notarywebsite.models.Order;
import com.jenniferlholmes.notarywebsite.services.OrderService;
import com.jenniferlholmes.notarywebsite.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/orders")

public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("")
	public String OrderForm(@ModelAttribute("order") Order order, HttpSession session, Model model) {
		List<Order> allOrders = orderService.findAll();
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("userId", (Long)session.getAttribute("loggedInUser"));
		
		
		return "welcome.jsp";
	}
	
	@PostMapping("")
	public String createOrder(@Valid @ModelAttribute("order") Order order, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/welcome.jsp";
		}
		orderService.create(order);
		return "redirect:/reciept";
	}	
	
	//Display One Order 
	@GetMapping("/{id}")
	public String displayOrder(@PathVariable() Long id, Model model) {
		Order ordersFromDB = orderService.findOne(id);
		model.addAttribute("order", ordersFromDB);
		return "receipt.jsp";
	}
	
		
	//Delete an Order
	@DeleteMapping("/delete/{id}")
    public String deleteCeleb(@PathVariable("id") Long id) {
        orderService.destroy(id);
        return "redirect:/welcome";
    }
}
