package com.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProformaInvoice {
	@Id
	@UuidGenerator
	private String proformaId;
	private String companyId;
	private String employeeId;
	private String invoiceNumber;
	private LocalDate invoiceDate;
	private LocalDateTime createdDateTime;
	private String purchaseOrder;
	private LocalDate purchaseDate;
	private String vendorCode;
	private String gstin;
	private String state;
	private String PanNumber;
	private String companyName;
	private String companyAddress;
	private String companyCountry;
	private String companyState;
	private String companyCity;
	private String companyGSTIN;
	private String companyPanNumber;
	private double advancePercentage;
	
	
	
	public ProformaInvoice(String proformaId, String companyId, String employeeId, String invoiceNumber,
			LocalDate invoiceDate, LocalDateTime createdDateTime, String purchaseOrder, LocalDate purchaseDate,
			String vendorCode, String gstin, String state, String panNumber, String companyName, String companyAddress,
			String companyCountry, String companyState, String companyCity, String companyGSTIN,
			String companyPanNumber, double advancePercentage) {
		super();
		this.proformaId = proformaId;
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.createdDateTime = createdDateTime;
		this.purchaseOrder = purchaseOrder;
		this.purchaseDate = purchaseDate;
		this.vendorCode = vendorCode;
		this.gstin = gstin;
		this.state = state;
		this.PanNumber = panNumber;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyCountry = companyCountry;
		this.companyState = companyState;
		this.companyCity = companyCity;
		this.companyGSTIN = companyGSTIN;
		this.companyPanNumber = companyPanNumber;
		this.advancePercentage = advancePercentage;
	}
	public ProformaInvoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProformaId() {
		return proformaId;
	}
	public void setProformaId(String proformaId) {
		this.proformaId = proformaId;
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
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPanNumber() {
		return PanNumber;
	}
	public void setPanNumber(String panNumber) {
		PanNumber = panNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyCountry() {
		return companyCountry;
	}
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}
	public String getCompanyState() {
		return companyState;
	}
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getCompanyGSTIN() {
		return companyGSTIN;
	}
	public void setCompanyGSTIN(String companyGSTIN) {
		this.companyGSTIN = companyGSTIN;
	}
	public String getCompanyPanNumber() {
		return companyPanNumber;
	}
	public void setCompanyPanNumber(String companyPanNumber) {
		this.companyPanNumber = companyPanNumber;
	}
	public double getAdvancePercentage() {
		return advancePercentage;
	}
	public void setAdvancePercentage(double advancePercentage) {
		this.advancePercentage = advancePercentage;
	}
	
	

}
