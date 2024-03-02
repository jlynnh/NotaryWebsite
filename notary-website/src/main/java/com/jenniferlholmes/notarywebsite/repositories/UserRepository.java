package com.jenniferlholmes.notarywebsite.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jenniferlholmes.notarywebsite.models.User;

@Repository

public interface UserRepository extends CrudRepository <User, Long>{
	
	List <User> findAll();
	
	public User findByEmail(String email);
	
	
}
