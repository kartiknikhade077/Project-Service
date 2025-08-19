package com.project.dto;

import java.util.List;

import com.project.entity.QuotationConsiderations;
import com.project.entity.QuotationParts;
import com.project.entity.Quotations;

public class QuotationRequestDTO {
	
	private Quotations quotationInfo;
	private List<QuotationParts> quotationParts;
	private List<QuotationConsiderations> quotationConsiderations;
	
	
	public Quotations getQuotationInfo() {
		return quotationInfo;
	}
	public void setQuotationInfo(Quotations quotationInfo) {
		this.quotationInfo = quotationInfo;
	}
	public List<QuotationParts> getQuotationParts() {
		return quotationParts;
	}
	public void setQuotationParts(List<QuotationParts> quotationParts) {
		this.quotationParts = quotationParts;
	}
	public List<QuotationConsiderations> getQuotationConsiderations() {
		return quotationConsiderations;
	}
	public void setQuotationConsiderations(List<QuotationConsiderations> quotationConsiderations) {
		this.quotationConsiderations = quotationConsiderations;
	}

	
	

}
