package com.project.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class QuotationConsiderations {
	@Id
	@UuidGenerator
	private String id;
	private String titel;
	private String description;
	private String quotationId;
	
	
	
	public QuotationConsiderations(String id, String titel, String description) {
		super();
		this.id = id;
		this.titel = titel;
		this.description = description;
	}
	public QuotationConsiderations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}
	
	
	

}
