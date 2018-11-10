package com.joh.thms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.thms.dao.ReportDAO;
import com.joh.thms.domain.model.NotificationD;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDAO reportDAO;

	@Override
	public List<NotificationD> findAdminNotifications() {
		return reportDAO.findAdminNotifications();
	}

	@Override
	public List<String> findAllChronicDisease() {
		return reportDAO.findAllChronicDisease();
	}
	

	@Override
	public List<String> findAllExamination() {
		return reportDAO.findAllExamination();
	}

}
