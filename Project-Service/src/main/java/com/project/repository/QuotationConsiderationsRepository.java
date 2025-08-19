package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.QuotationConsiderations;

import jakarta.transaction.Transactional;

public interface QuotationConsiderationsRepository extends JpaRepository<QuotationConsiderations, String> {

	
	@Modifying
	@Transactional
	@Query("DELETE FROM QuotationConsiderations qp WHERE qp.id IN :ids")
	void deleteQuotationConsiderationId(@Param("ids") List<String> ids);
	
	List<QuotationConsiderations> findByQuotationId(String quotationId);
}
