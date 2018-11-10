package com.joh.thms.dao;

import org.springframework.data.repository.CrudRepository;

import com.joh.thms.model.Doctor;

public interface DoctorDAO extends CrudRepository<Doctor, Integer> {

}
