package com.project.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.project.dto.QuotationRequestDTO;
import com.project.entity.QuotationConsiderations;
import com.project.entity.QuotationPartImages;
import com.project.entity.QuotationPartProcess;
import com.project.entity.QuotationParts;
import com.project.entity.Quotations;
import com.project.repository.QuotationConsiderationsRepository;
import com.project.repository.QuotationPartImagesRepository;
import com.project.repository.QuotationPartProcessRepository;
import com.project.repository.QuotationPartsRepository;
import com.project.repository.QuotationRepository;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

	@Autowired
	private UserSerivceClinet userSerivceClinet;
	@Autowired
	private QuotationRepository quotationRepository;
	@Autowired
	private QuotationPartsRepository quotationPartsRepository;
	@Autowired
	private QuotationPartProcessRepository quotationPartProcessRepository;
	@Autowired
	private QuotationPartImagesRepository quotationPartImagesRepository;
	@Autowired
	private QuotationConsiderationsRepository quotationConsiderationsRepository;

	Company company;

	@ModelAttribute
	public void companyDetails() {

		company = userSerivceClinet.getCompanyInfo();

	}

	@PostMapping("/createQuotation")
	public ResponseEntity<?> createQuotation(@RequestBody QuotationRequestDTO request) {
		try {
			Map<String, Object> response = new LinkedHashMap<String, Object>();

			Quotations info = request.getQuotationInfo();
			info.setCreatedDateTime(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
			info.setCompanyId(company.getCompanyId());
			quotationRepository.save(info);

			List<QuotationParts> quotationParts = new ArrayList<QuotationParts>();
			List<QuotationPartProcess> quotationPartProcesses = new ArrayList<QuotationPartProcess>();
			List<QuotationPartImages> quotationPartImages = new ArrayList<QuotationPartImages>();
			List<QuotationConsiderations> quotationConsiderations = new ArrayList<QuotationConsiderations>();
			for (QuotationParts part : request.getQuotationParts()) {
				part.setQuotationId(info.getQuotationId());

				quotationPartsRepository.save(part);

				quotationParts.add(part);
				if (part.getPartProcess() != null) {
					for (QuotationPartProcess process : part.getPartProcess()) {

						process.setQuotationPartId(part.getQuotationPartId());

						quotationPartProcessRepository.save(process);

						quotationPartProcesses.add(process);
					}
				}

				if (part.getPartImages() != null) {
					for (String images : part.getPartImages()) {

						QuotationPartImages image = new QuotationPartImages();

						image.setQuotationPartId(part.getQuotationPartId());
						byte[] decodedBytesImage = Base64.getDecoder().decode(images);
						image.setImage(decodedBytesImage);

						quotationPartImagesRepository.save(image);

						quotationPartImages.add(image);
					}
				}
			}

			for (QuotationConsiderations consideration : request.getQuotationConsiderations()) {
				consideration.setQuotationId(info.getQuotationId());
				quotationConsiderationsRepository.save(consideration);

				quotationConsiderations.add(consideration);
			}

			response.put("quotationInfo", info);
			response.put("quotationParts", quotationParts);
			response.put("quotationPartProcesses", quotationPartProcesses);
			response.put("quotationPartImages", quotationPartImages);
			response.put("quotationConsiderations", quotationConsiderations);

			return ResponseEntity.ok(response);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}

	@PutMapping("/updateQuotationInfo")
	public ResponseEntity<?> updateQuotationInfo(@RequestBody Quotations quotations) {
		try {
			quotations.setCompanyId(company.getCompanyId());
			quotationRepository.save(quotations);

			return ResponseEntity.ok(quotations);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@PutMapping("/updateQuotationParts")
	public ResponseEntity<?> updateQuotationParts(@RequestBody List<QuotationParts> quotationsParts) {
		try {

			for (QuotationParts part : quotationsParts) {

				quotationPartsRepository.save(part);
				if (part.getPartImages() != null) {
					for (String images : part.getPartImages()) {

						QuotationPartImages image = new QuotationPartImages();

						image.setQuotationPartId(part.getQuotationPartId());
						byte[] decodedBytesImage = Base64.getDecoder().decode(images);
						image.setImage(decodedBytesImage);

						quotationPartImagesRepository.save(image);

					}
				}
			}

			return ResponseEntity.ok(quotationsParts);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@PutMapping("/updateQuotationPartProcess")
	public ResponseEntity<?> updateQuotationPartProcess(
			@RequestBody List<QuotationPartProcess> quotationsPartProcesses) {
		try {

			quotationPartProcessRepository.saveAll(quotationsPartProcesses);

			return ResponseEntity.ok(quotationsPartProcesses);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@PutMapping("/updateQuotationConsideration")
	public ResponseEntity<?> updateQuotationConsideration(
			@RequestBody List<QuotationConsiderations> quotationsConsiderations) {
		try {

			quotationConsiderationsRepository.saveAll(quotationsConsiderations);

			return ResponseEntity.ok(quotationsConsiderations);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@DeleteMapping("/deleteQuotationPart")
	public ResponseEntity<?> deleteQuotationPart(@RequestBody List<String> partIds) {

		try {

			quotationPartsRepository.deleteQuotationParts(partIds);
			quotationPartProcessRepository.deleteQuotationPartsProcess(partIds);
			quotationPartImagesRepository.deleteQuotationPartImages(partIds);
			return ResponseEntity.ok("Deleted Successully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@DeleteMapping("/deleteQuotationPartProcess")
	public ResponseEntity<?> deleteQuotationPartProcess(@RequestBody List<String> processIds) {

		try {

			quotationPartProcessRepository.deleteQuotationPartsProcessByprocessId(processIds);

			return ResponseEntity.ok("Deleted Successully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@DeleteMapping("/deleteQuotationPartImages")
	public ResponseEntity<?> deleteQuotationPartImages(@RequestBody List<String> imageIds) {

		try {

			quotationPartImagesRepository.deleteQuotationPartImagesById(imageIds);

			return ResponseEntity.ok("Deleted Successully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}

	@DeleteMapping("/deleteQuotationConsideration")
	public ResponseEntity<?> deleteQuotationConsideration(@RequestBody List<String> considerationIds) {

		try {

			quotationConsiderationsRepository.deleteQuotationConsiderationId(considerationIds);

			return ResponseEntity.ok("Deleted Successully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}
	
	@GetMapping("/getQuoatation/{quotationId}")
	public ResponseEntity<?> deleteQuotationConsideration(@PathVariable String quotationId) {

		try {

			Map<String,Object> response=new LinkedHashMap<String,Object>();
			
           response.put("quotationInfo",  quotationRepository.findById(quotationId));
          
           List<QuotationParts> parts=quotationPartsRepository.findByQuotationId(quotationId);
           
           for(QuotationParts part: parts) {
        	   
        	   List<byte[]> rawImages = quotationPartImagesRepository.findByQuotationPartId(part.getQuotationPartId());
               
               List<String> base64Images = rawImages.stream()
                   .map(img -> Base64.getEncoder().encodeToString(img))
                   .collect(Collectors.toList());

               // Set images and process to part
               part.setPartImages(base64Images);
        	   List<QuotationPartProcess> proccess=quotationPartProcessRepository.findByquotationPartId(part.getQuotationPartId());
        	 
        	   part.setPartProcess(proccess);
           }
           
           List<QuotationConsiderations> consideration=quotationConsiderationsRepository.findByQuotationId(quotationId);
           
           response.put("partsAndProcess", parts);
           response.put("consideration", consideration);
           
              

			return ResponseEntity.ok(response);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}

	}
	
	@GetMapping("/getAllQuotation/{page}/{size}")
	public ResponseEntity<?> getAllProjects(@PathVariable int page,@PathVariable int size, @RequestParam(defaultValue = "") String companyName) {
		try {
			
			
			Map<String ,Object> data=new HashMap<String , Object>();
			 Pageable pageable = PageRequest.of(page, size, Sort.by("createdDateTime").descending());
			
		        Page<Quotations> quotationPage = quotationRepository.findByCompanyIdAndCompanyNameContainingIgnoreCase(company.getCompanyId(),companyName, pageable);
		        List<Quotations> quotationList = quotationPage.getContent();
		        data.put("projectList", quotationList);
		        data.put("totalPages", quotationPage.getTotalPages());
		        data.put("currentPage", quotationPage.getNumber());
			return ResponseEntity.ok(data);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
		}
	}
	
	

}
