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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="customer")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//First Name
	@NotEmpty(message="Please enter your first name.")
	@NotNull(message="First name must contain characters.")
	private String firstName;	
	
	//Last Name
	@NotEmpty(message="Please enter your last name.")
	@NotNull(message="Last name must contain characters.")
	private String lastName;
	
	//Street Address
	@NotEmpty(message="Please enter your street address.")
	@NotNull(message="Addresses must contain characters.")
	private String address;
	
	//City
	@NotEmpty(message="Please enter your city.")
	@NotNull(message="City name must contain characters.")
	private String city;
	
	//State
	@NotEmpty(message="Please enter your two character state.")
	@NotNull(message="Please enter your two character state.")
	@Size(min=2, max=2, message="State cannot be more or less than two characters.")
	private String state;
	
	//Zip
	@NotEmpty(message="Please enter your 5 digit zip.")
	@NotNull(message="Please enter your 5 digit zip.")
	@Size(min=5, max=5, message="Zip code cannot be more or less than five characters.")
	private String zip;
	
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
	private List<Document> document;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Customer () {}

	public Customer(Long id, Date createdAt, Date updatedAt,
			@NotEmpty(message = "Please enter your first name.") @NotNull(message = "First name must contain characters.") String firstName,
			@NotEmpty(message = "Please enter your last name.") @NotNull(message = "Last name must contain characters.") String lastName,
			@NotEmpty(message = "Please enter your street address.") @NotNull(message = "Addresses must contain characters.") String address,
			@NotEmpty(message = "Please enter your city.") @NotNull(message = "City name must contain characters.") String city,
			@NotEmpty(message = "Please enter your two character state.") @NotNull(message = "Please enter your two character state.") @Size(min = 2, max = 2, message = "State cannot be more or less than two characters.") String state,
			@NotEmpty(message = "Please enter your 5 digit zip.") @NotNull(message = "Please enter your 5 digit zip.") @Size(min = 5, max = 5, message = "Zip code cannot be more or less than five characters.") String zip) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

}
