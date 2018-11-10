package com.joh.thms.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.joh.thms.model.Patient;

public interface PatientDAO extends CrudRepository<Patient, Integer> {
}
