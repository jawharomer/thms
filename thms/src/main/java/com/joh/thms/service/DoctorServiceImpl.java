package com.joh.thms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.thms.dao.DoctorDAO;
import com.joh.thms.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDAO doctorDAO;

	@Override
	public Doctor findOne(int id) {
		return doctorDAO.findOne(id);
	}
}
