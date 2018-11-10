package com.joh.thms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joh.thms.domain.model.NotificationD;
import com.joh.thms.service.ReportService;

@Controller()
@RequestMapping(path = "/admin")
public class AdminController {

	private static final Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private ReportService reportService;

	@GetMapping()
	public String getAllNotification(Model model) {
		logger.info("getAllNotification->fired");

		List<NotificationD> notificationDs = reportService.findAdminNotifications();
		model.addAttribute("notificationDs", notificationDs);

		return "notifications";
	}

}
