package com.jenniferlholmes.notarywebsite.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginUser {
	@NotBlank(message="Email is required.")
	@Email(message="Please enter a valid email.")
	private String email;
	
	@NotNull(message="Password is required.")
	@NotBlank(message="Password cannot be blank.")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
	private String password;
	
	public LoginUser () {
		
	}

	public LoginUser(
			@NotBlank(message = "Email is required.") @Email(message = "Please enter a valid email.") String email,
			@NotNull(message = "Password is required.") @NotBlank(message = "Password cannot be blank.") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters.") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
