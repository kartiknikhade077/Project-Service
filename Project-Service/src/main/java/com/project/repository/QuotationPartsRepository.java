package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.QuotationParts;

import jakarta.transaction.Transactional;

public interface QuotationPartsRepository extends JpaRepository<QuotationParts, String>{
	
	@Modifying
	@Transactional
	@Query("DELETE FROM QuotationParts qp WHERE qp.quotationPartId IN :ids")
	void deleteQuotationParts(@Param("ids") List<String> ids);
	
	
	List<QuotationParts> findByQuotationId(String quotationId);


}
