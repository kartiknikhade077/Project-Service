package com.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Quotations;

public interface QuotationRepository extends JpaRepository<Quotations, String> {
	
	Page<Quotations> findByCompanyIdAndCompanyNameContainingIgnoreCase(String companyId,String companyName,Pageable pageable);

}
