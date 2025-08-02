package com.project.entity;

import java.time.LocalDate;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Projects {
	
	@Id
    @UuidGenerator
	private String projectId;
	private String companyId;
	private String employeeId;
	private String projectName;
	private long customerid;
	private String billingType;
	private String projectStatus;
	private String projectEstimate;
	private String estimateHours;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate createdDate;
	private String description;
	private String projectMembers;
	public Projects(String projectId, String companyId, String employeeId, String projectName, long customerid,
			String billingType, String projectStatus, String projectEstimate, String estimateHours,
			LocalDate startDate, LocalDate endDate, LocalDate createdDate, String description, String projectMembers) {
		super();
		this.projectId = projectId;
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.projectName = projectName;
		this.customerid = customerid;
		this.billingType = billingType;
		this.projectStatus = projectStatus;
		this.projectEstimate = projectEstimate;
		this.estimateHours = estimateHours;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdDate = createdDate;
		this.description = description;
		this.projectMembers = projectMembers;
	}
	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectEstimate() {
		return projectEstimate;
	}
	public void setProjectEstimate(String projectEstimate) {
		this.projectEstimate = projectEstimate;
	}
	public String getEstimateHours() {
		return estimateHours;
	}
	public void setEstimateHours(String estimateHours) {
		this.estimateHours = estimateHours;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProjectMembers() {
		return projectMembers;
	}
	public void setProjectMembers(String projectMembers) {
		this.projectMembers = projectMembers;
	}
	
	
	
	
	

}
