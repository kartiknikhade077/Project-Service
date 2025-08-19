package com.project.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class QuotationPartImages {
	@Id
	@UuidGenerator
	private String id;
	@Lob
	private byte[] image;
	private String quotationPartId;
	public QuotationPartImages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuotationPartImages(String id, byte[] image, String quotationPartId) {
		super();
		this.id = id;
		this.image = image;
		this.quotationPartId = quotationPartId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getQuotationPartId() {
		return quotationPartId;
	}
	public void setQuotationPartId(String quotationPartId) {
		this.quotationPartId = quotationPartId;
	}
	
	

}
