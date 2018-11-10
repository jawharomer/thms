package com.joh.thms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joh.thms.model.Patient;
import com.joh.thms.model.VisitReference;
import com.joh.thms.service.DoctorService;
import com.joh.thms.service.PatientService;
import com.joh.thms.service.ReportService;
import com.joh.thms.service.VisitReferenceService;

@Controller()
@RequestMapping(path = "/patients")
public class PatientController {

	private static final Logger logger = Logger.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@Autowired
	private VisitReferenceService visitReferenceService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ReportService reportService;
	
	



	@GetMapping(path = "/edit/{id}")
	public String getEditingPatient(@PathVariable int id, Model model) throws JsonProcessingException {
		logger.info("getEditingPatient->fired");
		logger.info("id=" + id);

		ObjectMapper mapper = new ObjectMapper();

		Iterable<VisitReference> visitReferences = visitReferenceService.findAll();

		Patient patient = patientService.findOne(id);
		logger.info("patient=" + patient);

		List<String> chronicDiseases = reportService.findAllChronicDisease();
		logger.info("chronicDiseases=" + chronicDiseases);

		model.addAttribute("jsonPatient", mapper.writeValueAsString(patient));
		System.err.println(" mapper.writeValueAsString(patient)=" + mapper.writeValueAsString(patient));

		model.addAttribute("jsonVisitReferences", mapper.writeValueAsString(visitReferences));
		model.addAttribute("jsonChronicDiseases", mapper.writeValueAsString(chronicDiseases));

		return "editPatient";
	}
	
	
	@PostMapping(path = "/update")
	public String addPatient(@RequestBody @Valid Patient patient, BindingResult result, HttpServletResponse response,
			Model model) throws JsonProcessingException {
		logger.info("addPatient->fired");

		logger.info("patient=" + patient);

		logger.info("errors=" + result.getAllErrors());

		if (result.hasErrors()) {

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			ObjectMapper mapper = new ObjectMapper();

			Iterable<VisitReference> visitReferences = visitReferenceService.findAll();
			List<String> chronicDiseases = reportService.findAllChronicDisease();
			logger.info("chronicDiseases=" + chronicDiseases);

			model.addAttribute("jsonPatient", mapper.writeValueAsString(patient));
			model.addAttribute("jsonVisitReferences", mapper.writeValueAsString(visitReferences));
			model.addAttribute("jsonChronicDiseases", mapper.writeValueAsString(chronicDiseases));
			

			return "addPatient";

		} else {
			patientService.update(patient);
			return "success";
		}

	}

}
