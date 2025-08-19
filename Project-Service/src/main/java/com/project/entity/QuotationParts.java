package com.project.entity;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class QuotationParts {
	@Id
	@UuidGenerator
	private String quotationPartId;
	private String quotationId;
	private String partName;
	private String partNo;
	private String partSize;
	private String material;
	private String thickness;
	@Transient
	private List<String> partImages;
	@Transient
	private List<QuotationPartProcess> partProcess;
	
	
	public QuotationParts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuotationParts(String quotationPartId, String quotationId, String partName, String partNo, String partSize,
			String material, String thickness) {
		super();
		this.quotationPartId = quotationPartId;
		this.quotationId = quotationId;
		this.partName = partName;
		this.partNo = partNo;
		this.partSize = partSize;
		this.material = material;
		this.thickness = thickness;
	}
	public String getQuotationPartId() {
		return quotationPartId;
	}
	public void setQuotationPartId(String quotationPartId) {
		this.quotationPartId = quotationPartId;
	}
	public String getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPartSize() {
		return partSize;
	}
	public void setPartSize(String partSize) {
		this.partSize = partSize;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public List<String> getPartImages() {
		return partImages;
	}
	public void setPartImages(List<String> partImages) {
		this.partImages = partImages;
	}
	public List<QuotationPartProcess> getPartProcess() {
		return partProcess;
	}
	public void setPartProcess(List<QuotationPartProcess> partProcess) {
		this.partProcess = partProcess;
	}
	

	

}
