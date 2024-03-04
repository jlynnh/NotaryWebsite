package com.jenniferlholmes.notarywebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jenniferlholmes.notarywebsite.models.Order;
import com.jenniferlholmes.notarywebsite.models.User;
import com.jenniferlholmes.notarywebsite.services.OrderService;
import com.jenniferlholmes.notarywebsite.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class HomeController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/welcome")
	public String welcome(@ModelAttribute ("order") Order order, HttpSession session, Model model) {
		
		if(session.getAttribute("loggedInUser") == null) {
			return "redirect:/login-registration";
		}
		
		User userFromDb = uService.findOne((Long)session.getAttribute("loggedInUser"));
		/* List <Order> allOrders = orderService.findAll(); */
		model.addAttribute("username", userFromDb.getUsername());
		/* model.addAttribute("order", allOrders); */
		return "welcome.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login-registration";
	}
}
