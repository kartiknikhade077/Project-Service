package com.project.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class QuotationPartProcess {
    @Id
    @UuidGenerator
	private String partProcessId;
    private String quotationPartId;
    private String oprationNumber;
    private String description;
    private double length;
    private double width;
    private double height;
    private double totalCost;
    private float factor;
    private float rate;
    
    
    
	public QuotationPartProcess(String partProcessId, String quotationPartId, String oprationNumber, String description,
			double length, double width, double height, double totalCost, float factor, float rate) {
		super();
		this.partProcessId = partProcessId;
		this.quotationPartId = quotationPartId;
		this.oprationNumber = oprationNumber;
		this.description = description;
		this.length = length;
		this.width = width;
		this.height = height;
		this.totalCost = totalCost;
		this.factor = factor;
		this.rate = rate;
	}
	public QuotationPartProcess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPartProcessId() {
		return partProcessId;
	}
	public void setPartProcessId(String partProcessId) {
		this.partProcessId = partProcessId;
	}
	public String getQuotationPartId() {
		return quotationPartId;
	}
	public void setQuotationPartId(String quotationPartId) {
		this.quotationPartId = quotationPartId;
	}
	public String getOprationNumber() {
		return oprationNumber;
	}
	public void setOprationNumber(String oprationNumber) {
		this.oprationNumber = oprationNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public float getFactor() {
		return factor;
	}
	public void setFactor(float factor) {
		this.factor = factor;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
    
    

}
