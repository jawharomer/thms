package com.joh.thms.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joh.thms.model.ReceptionPatientVisit;

public interface ReceptionPatientVisitDAO extends CrudRepository<ReceptionPatientVisit, Integer> {
	List<ReceptionPatientVisit> findAllByDoctorIdAndVisitDateBetween(int id, Date from, Date to);

}
