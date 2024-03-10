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
import org.springframework.web.bind.annotation.RequestMethod;

import com.jenniferlholmes.notarywebsite.models.Order;
import com.jenniferlholmes.notarywebsite.models.User;
import com.jenniferlholmes.notarywebsite.services.OrderService;
import com.jenniferlholmes.notarywebsite.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller

public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/welcome")
	public String welcome(@ModelAttribute ("order") Order order, HttpSession session, Model model) {
		List<Order> allOrders = orderService.findAll();
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("userId",(Long) session.getAttribute("loggedInUser"));
		if(session.getAttribute("loggedInUser") == null) {
			return "redirect:/login-registration";
		}
		
		User userFromDb = uService.findOne((Long)session.getAttribute("loggedInUser"));
		/* List <Order> allOrders = orderService.findAll(); */
		model.addAttribute("username", userFromDb.getUsername());
		/* model.addAttribute("order", allOrders); */
		return "welcome.jsp";
	}
	
	@PostMapping("/welcome")
	public String createOrder(@Valid @ModelAttribute("order") Order order, BindingResult result) {
		
		if(result.hasErrors()) {
		return "redirect:/welcome";
		}
		orderService.create(order);
		return "receipt.jsp";
	}	
	
	//Display All Orders
	@GetMapping("/admin")
	public String adminPage(@ModelAttribute("orderForm") Order order, HttpSession session, Model model){
		List<Order> adminAllOrders = orderService.findAll();
		model.addAttribute("order", adminAllOrders);model.addAttribute("userId",(Long) session.getAttribute("loggedInUser"));
		if(session.getAttribute("loggedInUser") == null) {
			return "redirect:/login-registration";
		}
		
		User userFromDb = uService.findOne((Long)session.getAttribute("loggedInUser"));
		List <Order> allOrders = orderService.findAll(); 
		model.addAttribute("username", userFromDb.getUsername());
		model.addAttribute("orders", allOrders);
		return "admin.jsp";
	}
		
	//Edit One Order
	@GetMapping("/admin/edit/{id}")
	public String displayOrder(@PathVariable("id") Long id,@ModelAttribute("orderForm") Order order, Model model) {
		Order ordersFromDB = orderService.findOne(id);
		model.addAttribute("order", ordersFromDB);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/admin/edit/{id}", method=RequestMethod.PUT)
    public String updateOrder(@Valid @ModelAttribute("id") Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("order", order);
            return "admin.jsp";
        } else {
            orderService.update(order);
            return "redirect:/welcome";
        }
    }

	@PostMapping("/admin/expense/{id}")
    public String updateSection(@PathVariable("id") Long id, @Valid @ModelAttribute("order") BindingResult result, Order order, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("order", orderService.findOne(id));
            return "redirect:/admin/edit/{id}";
        } else {
            orderService.update(order);
            return "redirect:/receipt";
        }
    }
	
	//Delete an Order
	@DeleteMapping("/admin/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.destroy(id);
        return "redirect:/admin";
    }
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login-registration";
	}
}
