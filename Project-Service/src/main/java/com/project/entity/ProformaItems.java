package com.project.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProformaItems {
	@Id
	@UuidGenerator
	private String proformaItemId;
	private String proformaId;
	private String purchaseOrderNumber;
	private String itemNumber;
	private String description;
	private String HSNCode;
	private int quantity;
	private String unit;
	private double value;
	
	
	public ProformaItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProformaItems(String proformaItemId, String proformaId, String purchaseOrderNumber, String itemNumber,
			String description, String hSNCode, int quantity, String unit, double value) {
		super();
		this.proformaItemId = proformaItemId;
		this.proformaId = proformaId;
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.itemNumber = itemNumber;
		this.description = description;
		HSNCode = hSNCode;
		this.quantity = quantity;
		this.unit = unit;
		this.value = value;
	}
	public String getProformaItemId() {
		return proformaItemId;
	}
	public void setProformaItemId(String proformaItemId) {
		this.proformaItemId = proformaItemId;
	}
	public String getProformaId() {
		return proformaId;
	}
	public void setProformaId(String proformaId) {
		this.proformaId = proformaId;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHSNCode() {
		return HSNCode;
	}
	public void setHSNCode(String hSNCode) {
		HSNCode = hSNCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	

}
