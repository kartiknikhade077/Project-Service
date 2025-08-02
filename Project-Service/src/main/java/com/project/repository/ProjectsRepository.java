package com.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, String> {
	
	Page<Projects> findByCompanyIdAndProjectNameContainingIgnoreCase(String companyId,String projectName,Pageable pageable);
  
	Projects findByProjectId(String projectId);
}
