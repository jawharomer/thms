package com.joh.thms.service;

import java.util.Date;

import com.joh.thms.model.CourseAttend;
import com.joh.thms.model.PatientVisit;

public interface PatientVisitService {

	PatientVisit save(PatientVisit patientVisit);

	PatientVisit findOne(int id);

	PatientVisit update(PatientVisit patientVisit);

	Iterable<PatientVisit> findAllByTimeBetween(Date from, Date to);

	void addCourseAttend(int id, CourseAttend courseAttend);

	void deleteCourseAttend(int id, int courseAttendId);

	Iterable<PatientVisit> findAllHasCourseAt(Date to);

}
