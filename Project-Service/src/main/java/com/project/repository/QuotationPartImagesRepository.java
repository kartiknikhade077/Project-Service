package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.QuotationPartImages;

import jakarta.transaction.Transactional;

public interface QuotationPartImagesRepository extends JpaRepository<QuotationPartImages, String> {
	
	@Modifying
	@Transactional
	@Query("DELETE FROM QuotationPartImages qp WHERE qp.quotationPartId IN :ids")
	void deleteQuotationPartImages(@Param("ids") List<String> ids);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM QuotationPartImages qp WHERE qp.id IN :ids")
	void deleteQuotationPartImagesById(@Param("ids") List<String> ids);

	
	
	@Query("SELECT qp.image FROM QuotationPartImages qp WHERE qp.quotationPartId = :id")
	List<byte[]> findByQuotationPartId(@Param("id") String id);

}
