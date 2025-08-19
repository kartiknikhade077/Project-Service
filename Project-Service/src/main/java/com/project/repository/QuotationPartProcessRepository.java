package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.QuotationPartProcess;

import jakarta.transaction.Transactional;

public interface QuotationPartProcessRepository extends JpaRepository<QuotationPartProcess, String>{
	
	
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM QuotationPartProcess qp WHERE qp.quotationPartId IN :ids")
	void deleteQuotationPartsProcess(@Param("ids") List<String> ids);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM QuotationPartProcess qp WHERE qp.partProcessId IN :ids")
	void deleteQuotationPartsProcessByprocessId(@Param("ids") List<String> ids);
	
	List<QuotationPartProcess> findByquotationPartId(String partId);

}
