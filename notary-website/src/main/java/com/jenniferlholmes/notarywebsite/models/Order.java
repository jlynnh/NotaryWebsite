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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	//Document Type
	@NotEmpty (message = "Please ensure to pick a document type.")
	private String type;
		
	//Document Name
	@NotEmpty (message = "Please choose a document.")
	private String name;
		
	//Number of Pages
	@NotEmpty (message = "How many pages required for notarization?")
	@Size (min=1, max=250, message="Minimum of 1 page required.")
	private String pages;
	
	//Appointment Date 
	@Temporal(TemporalType.DATE)
	private Date appointmentDay;
			
	//Appointment Time
	@Temporal(TemporalType.TIME)
	private Date appointmentTime;	
	
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
			@NotEmpty(message = "Please ensure to pick a document type.") String type,
			@NotEmpty(message = "Please choose a document.") String name,
			@NotEmpty(message = "How many pages required for notarization?") @Size(min = 1, max = 250, message = "Minimum of 1 page required.") String pages,
			Date appointmentDay, Date appointmentTime, User user) {
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
		this.name = name;
		this.pages = pages;
		this.appointmentDay = appointmentDay;
		this.appointmentTime = appointmentTime;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public Date getAppointmentDay() {
		return appointmentDay;
	}

	public void setAppointmentDay(Date appointmentDay) {
		this.appointmentDay = appointmentDay;
	}

	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
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
