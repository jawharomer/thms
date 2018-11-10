package com.joh.thms.service;

import java.util.List;

import com.joh.thms.domain.model.NotificationD;

public interface ReportService {

	List<NotificationD> findAdminNotifications();

	List<String> findAllChronicDisease();

	List<String> findAllExamination();

}
