package com.jenniferlholmes.notarywebsite.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required.")
	@NotNull(message="Username is required.")
	@Size(min=3, max=30, message="Username must be between 3 and 30 characters.")
	private String username;
	
	@NotBlank(message="Email is required.")
	@Email(message="Please enter a valid email.")
	@NotNull(message="Email address cannot be blank.")
	private String email;
	
	@NotNull(message="Password is required.")
	@NotBlank(message="Password cannot be blank.")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
	private String password;
	
	@Transient
	@NotEmpty(message="Password confirmation is required.")
	@NotNull
	private String confirmPassword;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Order> order;
		
	public User() {}

	public User(Long id,
			@NotEmpty(message = "Username is required.") @NotNull(message = "Username is required.") @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters.") String username,
			@NotBlank(message = "Email is required.") @Email(message = "Please enter a valid email.") @NotNull(message = "Email address cannot be blank.") String email,
			@NotNull(message = "Password is required.") @NotBlank(message = "Password cannot be blank.") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters.") String password,
			@NotEmpty(message = "Password confirmation is required.") @NotNull String confirmPassword, Date createdAt,
			Date updatedAt, List<Order> order) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

		
}
