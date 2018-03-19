package com.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Representative;
import com.main.service.DrugService;
import com.main.service.RepresentativeService;
import com.main.util.ResponseMessage;

/**
 * 
 * @author Uday Garg
 *
 */
@RestController
public class RepresentativeController {

	@Autowired
	ResponseMessage responseMessage;
	@Autowired
	RepresentativeService representativeService;

	@Autowired
	DrugService drugService;

	/**
	 * 
	 * @RequestBody Representative
	 * @return ResponseEntity<Representative>
	 */
	@PostMapping(value = "createRepresentative")
	public ResponseEntity<Object> createRepresentative(
			@Valid @RequestBody Representative representative) {
		responseMessage = representativeService
				.CreateRepresentative(representative);
		if ("exists".equals(responseMessage.getStatus())) {
			return ResponseEntity.status(409).body(responseMessage);
		} else {
			return ResponseEntity.status(201).body(representative);
		}
	}

	/**
	 * 
	 * @param representative
	 * @return
	 */
	@PutMapping(value = "updateRepresentative")
	public ResponseEntity<Object> updateRepresentative(
			@Valid @RequestBody Representative representative) {
		responseMessage = representativeService
				.UpdateRepresentative(representative);
		if ("notFound".equals(responseMessage.getStatus())) {
			return ResponseEntity.status(404).body(responseMessage);
		}
		return ResponseEntity.ok(representative);
	}

	/**
	 * 
	 * @RequestParam id
	 * @return
	 */
	@DeleteMapping(value = "deleteRepresentative")
	public ResponseEntity<Object> deleteRepresentativeById(
			@RequestParam(value = "id") int id) {
		responseMessage = representativeService.DeleteRepresentativeById(id);
		if ("notFound".equals(responseMessage.getMessage())) {
			return ResponseEntity.status(404).body(responseMessage);
		}
		return ResponseEntity.ok().body(responseMessage);
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	@DeleteMapping(value = "deleteDrug")
	public ResponseEntity<Object> deleteDrugByIdAndName(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "name") String name) {
		responseMessage = drugService.DeleteDrugByIdAndName(id, name);
		if ("notFound".equals(responseMessage.getMessage())) {
			return ResponseEntity.status(404).body(responseMessage);
		}
		return ResponseEntity.ok().body(responseMessage);
	}

	/**
	 * 
	 * @param id
	 * @return representative detail with drugs assigned to him
	 */
	@GetMapping(value = "getRepresentative/{id}")
	public ResponseEntity<Object> getRepresentativeById(
			@PathVariable(value = "id") int id) {
		responseMessage = representativeService.GetRepresentativeById(id);
		if ("notFound".equals(responseMessage.getMessage())) {
			return ResponseEntity.status(404).body(responseMessage);
		}
		return ResponseEntity.ok(responseMessage);
	}

	/**
	 * 
	 * @return list of representatives without drugs
	 */
	@GetMapping(value = "getAllRepresentative")
	public ResponseEntity<Object> getAllRepresentative() {

		Object obj = representativeService.GetAllRepresentative();
		if (obj==null) {
			return ResponseEntity.status(404).body("No representative exists");
		}
		return ResponseEntity.ok(obj);
	}

}
