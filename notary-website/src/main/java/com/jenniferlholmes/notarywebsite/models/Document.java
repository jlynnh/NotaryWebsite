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
import jakarta.validation.constraints.Size;

@Entity
@Table (name="document")

public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
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
	
	//Signature Date (optional if the customer has already signed the document)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date signatureDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Document () {}

	public Document(Long id, Date createdAt, Date updatedAt,
			@NotEmpty(message = "Please ensure to pick a document type.") String type,
			@NotEmpty(message = "Please choose a document.") String name,
			@NotEmpty(message = "How many pages required for notarization?") @Size(min = 1, max = 250, message = "Minimum of 1 page required.") String pages,
			Date signatureDate) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.type = type;
		this.name = name;
		this.pages = pages;
		this.signatureDate = signatureDate;
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

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}	

}
