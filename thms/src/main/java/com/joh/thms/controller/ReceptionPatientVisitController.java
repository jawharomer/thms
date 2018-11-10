package com.joh.thms.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joh.thms.model.Doctor;
import com.joh.thms.model.ReceptionPatientVisit;
import com.joh.thms.service.DoctorService;
import com.joh.thms.service.ReceptionPatientVisitService;

@Controller()
@RequestMapping(path = "/receptionPatientVisits")
public class ReceptionPatientVisitController {

	private static final Logger logger = Logger.getLogger(ReceptionPatientVisitController.class);

	@Value("${reception.doctor.id}")
	private Integer receptionDoctorId;

	@Autowired
	private ReceptionPatientVisitService receptionPatientVisitService;

	@Autowired
	private DoctorService doctorService;

	@GetMapping()
	public String getAllReceptionPatientVisits(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to, Model model) {
		logger.info("getAllReceptionPatientVisits->fired");
		logger.info("receptionDoctorId=" + receptionDoctorId);

		Doctor doctor = doctorService.findOne(receptionDoctorId);
		logger.info("doctor=" + doctor);

		logger.info("from=" + from);
		logger.info("to=" + to);

		List<ReceptionPatientVisit> receptionPatientVisits = receptionPatientVisitService
				.findAllDoctorPatientVisit(receptionDoctorId, from, to);

		logger.info("receptionPatientVisits=" + receptionPatientVisits);

		model.addAttribute("receptionPatientVisits", receptionPatientVisits);
		model.addAttribute("from", from);
		model.addAttribute("to", to);

		model.addAttribute("doctor", doctor);

		return "receptionPatientVisits";
	}

}
