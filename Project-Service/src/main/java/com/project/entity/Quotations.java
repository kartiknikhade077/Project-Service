package com.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Quotations {
	
	@Id
	@UuidGenerator
	private String quotationId;
	private String companyId;
	private String employeeId;
	private String companyName;
	private String customerId;
	private String contactPersonName;
	private String address;
	private String refrence;
	private LocalDate quotationDate;
	private LocalDate validDate;
	private LocalDateTime createdDateTime;
	private String quotationNumber;
	private String supplierCode;
	private String projectName;
	private String message;
	public Quotations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quotations(String quotationId, String companyId, String employeeId, String companyName, String customerId,
			String contactPersonName, String address, String refrence, LocalDate quotationDate, String quotationNumber,
			String supplierCode, String projectName, String message) {
		super();
		this.quotationId = quotationId;
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.companyName = companyName;
		this.customerId = customerId;
		this.contactPersonName = contactPersonName;
		this.address = address;
		this.refrence = refrence;
		this.quotationDate = quotationDate;
		this.quotationNumber = quotationNumber;
		this.supplierCode = supplierCode;
		this.projectName = projectName;
		this.message = message;
	}
	public String getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRefrence() {
		return refrence;
	}
	public void setRefrence(String refrence) {
		this.refrence = refrence;
	}

	public String getQuotationNumber() {
		return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(LocalDate quotationDate) {
		this.quotationDate = quotationDate;
	}
	public LocalDate getValidDate() {
		return validDate;
	}
	public void setValidDate(LocalDate validDate) {
		this.validDate = validDate;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	

}
