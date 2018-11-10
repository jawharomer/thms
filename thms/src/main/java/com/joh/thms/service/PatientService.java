package com.joh.thms.service;

import java.util.Date;

import com.joh.thms.model.Patient;

public interface PatientService {

	Patient findOne(int id);

	Patient update(Patient patient);

}
