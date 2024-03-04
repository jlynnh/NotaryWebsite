package com.jenniferlholmes.notarywebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenniferlholmes.notarywebsite.models.Order;
import com.jenniferlholmes.notarywebsite.repositories.OrderRepository;

@Service

public class OrderService {
	
	@Autowired
	private OrderRepository repoOrder;
	
	//Get All
	public List <Order> findAll() {
		return repoOrder.findAll();	}
	
	//Find One By ID
		public Order findOne(Long id) {
			return repoOrder.findById(id).orElse(null);
		}
		
	//Create
	public Order create(Order order) {
		return repoOrder.save(order);
	}
	
	//Update
	public Order update(Order order) {
		return repoOrder.save(order);
	}
	
	//Delete
	public void destroy(Long id) {
		repoOrder.deleteById(id);
	}

}
