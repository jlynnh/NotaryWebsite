package com.jenniferlholmes.notarywebsite.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="orders")

public class Order {
	
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
	@NotEmpty(message="Last name is required.")
	@NotNull(message="Last name must contain characters.")
	private String lastName;
			
	//Street Address
	@NotEmpty(message="Please enter your street address.")
	@NotNull(message="Addresses must contain characters.")
	private String address;
			
	//Unit Number
	private String unit;
			
	//City
	@NotEmpty(message="Please enter your city.")
	@NotNull(message="City name must contain characters.")
	private String city;
			
	//Zip
	@NotEmpty(message="Please enter your 5 digit zip.")
	@NotNull(message="Please enter your 5 digit zip.")
	@Size(min=5, max=5, message="Zip code cannot be more or less than five characters.")
	private String zip;
	
	//Document Type for Document #1
	@NotEmpty (message = "Please ensure to pick a document type.")
	private String type;
	
	//Document Type for Document #2 Optional
	private String typeTwo;
	
	//Document Type for Document #3 Optional
	private String typeThree;
		
	//Document Name for Document #1
	@NotEmpty (message = "Please choose a document.")
	private String name;
	
	//Document Name for Document #2 Optional
	private String nameTwo;
	
	//Document Name for Document #3 Optional
		private String nameThree;	
		
	//Number of Pages for Document #1
	@NotEmpty (message = "How many pages required for notarization?")
	@Size (min=1, max=250, message="Minimum of 1 page required.")
	private String pages;
	
	//Number of Pages for Document #2 Optional
	@Size (min=0, max=250, message="Minimum of 1 page required.")
	private String pagesTwo;
	
	//Number of Pages for Document #3 Optional
	@Size (min=0, max=250, message="Minimum of 1 page required.")
	private String pagesThree;
	
	//Appointment Date 
	@NotEmpty (message = "Please include your preferred date.")
	private String appointment;
	
	//Appointment Time
	@NotEmpty (message = "Please include your preferred time slot.")
	private String timing;	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
		
	public Order () {}
	
	
	public Order(Long id, Date createdAt, Date updatedAt,
			@NotEmpty(message = "Please enter your first name.") @NotNull(message = "First name must contain characters.") String firstName,
			@NotEmpty(message = "Last name is required.") @NotNull(message = "Last name must contain characters.") String lastName,
			@NotEmpty(message = "Please enter your street address.") @NotNull(message = "Addresses must contain characters.") String address,
			String unit,
			@NotEmpty(message = "Please enter your city.") @NotNull(message = "City name must contain characters.") String city,
			@NotEmpty(message = "Please enter your 5 digit zip.") @NotNull(message = "Please enter your 5 digit zip.") @Size(min = 5, max = 5, message = "Zip code cannot be more or less than five characters.") String zip,
			@NotEmpty(message = "Please ensure to pick a document type.") String type, String typeTwo, String typeThree,
			@NotEmpty(message = "Please choose a document.") String name, String nameTwo, String nameThree,
			@NotEmpty(message = "How many pages required for notarization?") @Size(min = 1, max = 250, message = "Minimum of 1 page required.") String pages,
			@Size(min = 1, max = 250, message = "Minimum of 1 page required.") String pagesTwo,
			@Size(min = 1, max = 250, message = "Minimum of 1 page required.") String pagesThree,
			@NotEmpty(message = "Please include your preferred date.") String appointment,
			@NotEmpty(message = "Please include your preferred time slot.") String timing, User user) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.unit = unit;
		this.city = city;
		this.zip = zip;
		this.type = type;
		this.typeTwo = typeTwo;
		this.typeThree = typeThree;
		this.name = name;
		this.nameTwo = nameTwo;
		this.nameThree = nameThree;
		this.pages = pages;
		this.pagesTwo = pagesTwo;
		this.pagesThree = pagesThree;
		this.appointment = appointment;
		this.timing = timing;
		this.user = user;
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


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTypeTwo() {
		return typeTwo;
	}


	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}


	public String getTypeThree() {
		return typeThree;
	}


	public void setTypeThree(String typeThree) {
		this.typeThree = typeThree;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNameTwo() {
		return nameTwo;
	}


	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}


	public String getNameThree() {
		return nameThree;
	}


	public void setNameThree(String nameThree) {
		this.nameThree = nameThree;
	}


	public String getPages() {
		return pages;
	}


	public void setPages(String pages) {
		this.pages = pages;
	}


	public String getPagesTwo() {
		return pagesTwo;
	}


	public void setPagesTwo(String pagesTwo) {
		this.pagesTwo = pagesTwo;
	}


	public String getPagesThree() {
		return pagesThree;
	}


	public void setPagesThree(String pagesThree) {
		this.pagesThree = pagesThree;
	}


	


	public String getAppointment() {
		return appointment;
	}


	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}


	public String getTiming() {
		return timing;
	}


	public void setTiming(String timing) {
		this.timing = timing;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	
}
