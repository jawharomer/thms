package com.joh.thms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.thms.dao.ReceptionPatientVisitDAO;
import com.joh.thms.model.ReceptionPatientVisit;

@Service
public class ReceptionPatientVisitServiceImpl implements ReceptionPatientVisitService {

	@Autowired
	private ReceptionPatientVisitDAO receptionPatientVisitDAO;

	@Override
	public List<ReceptionPatientVisit> findAllDoctorPatientVisit(int id, Date from, Date to) {
		return receptionPatientVisitDAO.findAllByDoctorIdAndVisitDateBetween(id, from, to);

	}
}
