package com.joh.thms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.joh.thms.domain.model.NotificationD;
import com.joh.thms.domain.model.NotificationD.NotificationType;

@Component
public class ReportDAO {
	@PersistenceContext
	private EntityManager em;

	public List<NotificationD> findAdminNotifications() {

		List<NotificationD> notificationDs = new ArrayList<>();

		// Notification-1

		Query query = em.createNativeQuery(
				"SELECT COUNT(*) FROM THMS_PATIENT_VISITS WHERE VISIT_TIME BETWEEN CURDATE() AND CURDATE()+INTERVAL 1 DAY;");

		Object totalPatientVisitResult = query.getSingleResult();

		int totalPatientVisit = 0;
		if (totalPatientVisitResult != null)
			totalPatientVisit = Integer.parseInt("" + totalPatientVisitResult);

		//
		NotificationD not1 = new NotificationD();
		not1.setTitle("Total Today Patient Visit");
		not1.setEtc("" + totalPatientVisit);
		not1.setMessage("Total Number of patients visit in today");

		not1.setNotificationType(NotificationType.INFO);

		notificationDs.add(not1);

		// Notification-2

		query = em.createNativeQuery(
				"SELECT COUNT(*) FROM COURSE_ATTENDS  WHERE ATTEND_TIME BETWEEN CURDATE() AND CURDATE()+INTERVAL 1 DAY;");

		Object totalTodayAttendResult = query.getSingleResult();

		int totalTodayAttend = 0;
		if (totalTodayAttendResult != null)
			totalTodayAttend = Integer.parseInt("" + totalTodayAttendResult);

		//
		NotificationD not2 = new NotificationD();
		not2.setTitle("Total Today Patient Attend");
		not2.setEtc("" + totalTodayAttend);
		not2.setMessage("Total Number of patients attend in today");

		not2.setNotificationType(NotificationType.INFO);

		notificationDs.add(not2);

		return notificationDs;

	}

	public List<String> findAllChronicDisease() {
		List<String> chronicDiseases = new ArrayList<>();

		Query query = em.createNativeQuery("SELECT DISTINCT DISEASE_NAME FROM CHRONIC_DISEASES ORDER BY DISEASE_NAME;");

		List<String> totalChronicDisease = query.getResultList();
		chronicDiseases.addAll(totalChronicDisease);
		return chronicDiseases;
	}

	public List<String> findAllExamination() {
		List<String> examinations = new ArrayList<>();

		Query query = em.createNativeQuery("SELECT  DISTINCT EXAMINATION_NAME FROM EXAMINATIONS;");

		List<String> totalExaminations = query.getResultList();
		examinations.addAll(totalExaminations);
		return totalExaminations;
	}

}
