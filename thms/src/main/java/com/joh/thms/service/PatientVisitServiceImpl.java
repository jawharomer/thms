package com.joh.thms.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.thms.dao.PatientVisitDAO;
import com.joh.thms.model.CourseAttend;
import com.joh.thms.model.PatientVisit;

@Service
public class PatientVisitServiceImpl implements PatientVisitService {

	@Autowired
	private PatientVisitDAO patientVisitDAO;

	@Override
	public PatientVisit save(PatientVisit patientVisit) {
		return patientVisitDAO.save(patientVisit);
	}

	@Override
	public PatientVisit findOne(int id) {
		return patientVisitDAO.findOne(id);
	}

	@Override
	public PatientVisit update(PatientVisit patientVisit) {
		if (patientVisitDAO.findOne(patientVisit.getId()) == null) {
			throw new EntityNotFoundException();
		}
		return patientVisitDAO.save(patientVisit);
	}

	@Override
	public Iterable<PatientVisit> findAllByTimeBetween(Date from, Date to) {
		return patientVisitDAO.findAllByTimeBetween(from, to);
	}

	@Override
	public Iterable<PatientVisit> findAllHasCourseAt(Date to) {
		return patientVisitDAO.findAllByFromLessThanEqualAndToGreaterThanEqual(to, to);
	}

	@Override
	public void addCourseAttend(int id, CourseAttend courseAttend) {
		PatientVisit patientVisit = patientVisitDAO.findOne(id);
		patientVisit.getCourseAttends().add(courseAttend);
		patientVisitDAO.save(patientVisit);
	}

	@Override
	public void deleteCourseAttend(int id, int courseAttendId) {
		PatientVisit patientVisit = patientVisitDAO.findOne(id);
		patientVisit.getCourseAttends().removeIf(e -> e.getId() == courseAttendId);
		patientVisitDAO.save(patientVisit);

	}

}
