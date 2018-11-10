package com.joh.thms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joh.thms.dao.VisitReferenceDAO;
import com.joh.thms.model.VisitReference;

@Service
public class VisitReferenceServiceImpl implements VisitReferenceService {

	@Autowired
	private VisitReferenceDAO visitReferenceDAO;

	@Override
	public Iterable<VisitReference> findAll() {
		return visitReferenceDAO.findAll();
	}
}
