package com.joh.thms.service;

import java.util.Date;
import java.util.List;

import com.joh.thms.model.ReceptionPatientVisit;

public interface ReceptionPatientVisitService {

	List<ReceptionPatientVisit> findAllDoctorPatientVisit(int id, Date from, Date to);

}
