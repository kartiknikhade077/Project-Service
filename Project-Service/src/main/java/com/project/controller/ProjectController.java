package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.client.UserSerivceClinet;
import com.project.dto.Company;
import com.project.entity.Projects;
import com.project.repository.ProjectsRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {

	
	@Autowired
	private UserSerivceClinet userSerivceClinet;
  
	@Autowired
	private ProjectsRepository projectsRepository;

	@GetMapping
	public void testing() {

		System.err.println("Setting ");
	}

	Company company;

	@ModelAttribute
	public void companyDetails() {

		company = userSerivceClinet.getCompanyInfo();

	}
	
	@PostMapping("/createProject")
	public ResponseEntity<?> createProject(@RequestBody Projects project) {
		try {
			project.setCompanyId(company.getCompanyId());
			projectsRepository.save(project);

			return ResponseEntity.ok(project);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}
	
	@GetMapping("/getAllProjects/{page}/{size}")
	public ResponseEntity<?> getAllProjects(@PathVariable int page,@PathVariable int size, @RequestParam(defaultValue = "") String projectName) {
		try {
			
			
			Map<String ,Object> data=new HashMap<String , Object>();
			 Pageable pageable = PageRequest.of(page, size, Sort.by("projectId").descending());
			
		        Page<Projects> projectPage = projectsRepository.findByCompanyIdAndProjectNameContainingIgnoreCase(company.getCompanyId(),projectName, pageable);
		        List<Projects> projectList = projectPage.getContent();
		        data.put("projectList", projectList);
		        data.put("totalPages", projectPage.getTotalPages());
		        data.put("currentPage", projectPage.getNumber());
			return ResponseEntity.ok(data);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}
	
	
	@GetMapping("/getProjectById/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
		try {
			
			Projects project=projectsRepository.findByProjectId(projectId);
		    
			return ResponseEntity.ok(project);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}
	
	
	@PutMapping("/updateProject")
	public ResponseEntity<?> updateProject(@RequestBody Projects project) {
		try { 
			project.setCompanyId(company.getCompanyId());
			projectsRepository.save(project);
		    
			return ResponseEntity.ok(project);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}
	
	    
}
