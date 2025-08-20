package com.project.dto;

import java.util.List;

import com.project.entity.ProformaInvoice;
import com.project.entity.ProformaItems;

public class ProformaInvoiceDTO {
	
	private ProformaInvoice proformaInvoice;
	private List<ProformaItems> proformaItems;
	
	
	
	public ProformaInvoiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProformaInvoiceDTO(ProformaInvoice proformaInvoice, List<ProformaItems> proformaItems) {
		super();
		this.proformaInvoice = proformaInvoice;
		this.proformaItems = proformaItems;
	}
	public ProformaInvoice getProformaInvoice() {
		return proformaInvoice;
	}
	public void setProformaInvoice(ProformaInvoice proformaInvoice) {
		this.proformaInvoice = proformaInvoice;
	}
	public List<ProformaItems> getProformaItems() {
		return proformaItems;
	}
	public void setProformaItems(List<ProformaItems> proformaItems) {
		this.proformaItems = proformaItems;
	}
	
	

}
