package com.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.Projects;


public interface ProjectsRepository extends JpaRepository<Projects, String> {
	
	Page<Projects> findByCompanyIdAndProjectNameContainingIgnoreCase(String companyId,String projectName,Pageable pageable);
	Page<Projects> findByEmployeeIdAndProjectNameContainingIgnoreCase(String eemployeeId,String projectName,Pageable pageable);
  
	Projects findByProjectId(String projectId);
	
	List<Projects> findAllByCompanyId(String companyId);
	
	List<Projects> findByCustomerid(String customerid);
	
	@Query(value = "SELECT project_members FROM projects WHERE project_id = :projectId", nativeQuery = true)
	String findEmployeeIdsByProjectId(@Param("projectId") String projectId);

}
