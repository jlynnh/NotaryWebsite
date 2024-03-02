package com.jenniferlholmes.notarywebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jenniferlholmes.notarywebsite.models.LoginUser;
import com.jenniferlholmes.notarywebsite.models.User;
import com.jenniferlholmes.notarywebsite.repositories.UserRepository;

@Service

public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	//Create
	public User create(User user) {
		return repo.save(user);
	}
	
	//Update
		public User update(User user) {
			return repo.save(user);
		}
	
	//Find By ID
	public User findOne(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	//Find By Email
	public User authenticateUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	//Validate User Registration
	public void validateUser(User user, BindingResult result) {
		User userInDb = repo.findByEmail(user.getEmail());
		
		if (userInDb != null) {
			result.rejectValue("email", "unique", "User exists in database");
		}
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "matches", "Password must match Confirm Password.");
		}
	}
	
	public User authenticate(LoginUser loginUser, BindingResult result) {
		User userOrNull = repo.findByEmail(loginUser.getEmail());
		
		if (userOrNull == null) {
			result.rejectValue("email", "invalid", "invalid login");
			return null;
		}
		return userOrNull;
	}

}
