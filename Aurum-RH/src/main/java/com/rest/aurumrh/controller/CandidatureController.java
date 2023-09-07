package com.rest.aurumrh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.service.CandidatureServiceImpl;

@RestController
public class CandidatureController {

	@Autowired
	CandidatureServiceImpl candidatureServiceImpl;

	@GetMapping("/candidatures")
	public List<Candidature> getAllCandidatures() {

		return candidatureServiceImpl.getAllCandidatures();
	}

	@GetMapping("/candidatures/{id}")
	public Candidature getCandidatureById(@PathVariable(name = "id") int id) {

		return candidatureServiceImpl.getCandidatureById(id);
	}

	@PostMapping("/candidatures")
	public Candidature createCandidature(@RequestBody Candidature candidature) {

		return candidatureServiceImpl.createCandidature(candidature);
	}

	@PutMapping("/candidatures/{id}")
	public Candidature updateCandidature(@PathVariable(name = "id") int id, @RequestBody Candidature candidature) {

		Candidature selectedCandidature = new Candidature();
		Candidature updatedCandidature = new Candidature();

		selectedCandidature = candidatureServiceImpl.getCandidatureById(id);

		selectedCandidature.setName(candidature.getName());
		selectedCandidature.setLocation(candidature.getLocation());
		selectedCandidature.setClosingDate(candidature.getClosingDate());
		selectedCandidature.setTypeWorkingDate(candidature.getTypeWorkingDate());
		selectedCandidature.setApplicantsNum(candidature.getApplicantsNum());
		selectedCandidature.setDescription(candidature.getDescription());
		selectedCandidature.setRequirements(candidature.getRequirements());
		selectedCandidature.setResponsabilities(candidature.getResponsabilities());
		selectedCandidature.setState(candidature.isState());
		selectedCandidature.setCreator(candidature.getCreator());

		updatedCandidature = candidatureServiceImpl.updateCandidature(selectedCandidature);

		return updatedCandidature;
	}

	@DeleteMapping("/candidatures/{id}")
	public void deleteCandidature(@PathVariable(name = "id") int id) {

		candidatureServiceImpl.deleteCandidature(id);
	}

	// Usuarios ordenados alfabeticamente de forma ASC
	@GetMapping("/candidatures/name-asc")
	public List<Candidature> getAllCandidaturesASC() {

		return candidatureServiceImpl.getAllCandidaturesASC();
	}

	// Usuarios ordenados alfabeticamente de forma DESC
	@GetMapping("/candidatures/name-desc")
	public List<Candidature> getAllCandidaturesDESC() {

		return candidatureServiceImpl.getAllCandidaturesDESC();
	}

	// Buscar candidaturas que empiecen por X letras
	@GetMapping("/candidatures/search/{letters}")
	public List<Candidature> getAllCandidaturesStartingWith(@PathVariable(name = "letters") String letters) {

		return candidatureServiceImpl.getAllCandidaturesStartingWith(letters);
	}

	// Candidaturas ordenadas por estado abierto
	@GetMapping("/candidatures/order-open")
	public List<Candidature> getAllCandidaturesByOrderOpen() {

		return candidatureServiceImpl.getAllCandidaturesByOrderOpen();
	}

	// Candidaturas ordenadas por estado cerrado
	@GetMapping("/candidatures/order-close")
	public List<Candidature> getAllCandidaturesByOrderClose() {

		return candidatureServiceImpl.getAllCandidaturesByOrderClose();
	}

	// Buscar candidaturas que empiecen por X letras ordenadas por estado abierto
	@GetMapping("/candidatures/open/search/{letters}")
	public List<Candidature> getAllCandidaturesStartingWithByOrderOpen(@PathVariable(name = "letters") String letters) {

		return candidatureServiceImpl.getAllCandidaturesStartingWithByOrderOpen(letters);
	}

	// Buscar candidaturas que empiecen por X letras ordenadas por estado cerrado
	@GetMapping("/candidatures/close/search/{letters}")
	public List<Candidature> getAllCandidaturesStartingWithByOrderClose(@PathVariable(name = "letters") String letters) {

		return candidatureServiceImpl.getAllCandidaturesStartingWithByOrderClose(letters);
	}

	// Candidaturas abiertas
	@GetMapping("/candidatures/open")
	public List<Candidature> getAllCandidaturesOpen() {

		return candidatureServiceImpl.getAllCandidaturesOpen();
	}


	// Candidaturas cerradas
	@GetMapping("/candidatures/close")
	public List<Candidature> getAllCandidaturesClose() {

		return candidatureServiceImpl.getAllCandidaturesClose();
	}
}