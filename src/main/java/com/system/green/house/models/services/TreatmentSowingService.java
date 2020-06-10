package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.ITreatmentSowing;
import com.system.green.house.models.entities.TreatmentSowing;

@Service
public class TreatmentSowingService implements ITreatmentSowingService{
	@Autowired 
	private ITreatmentSowing dao;
	
	@Override
	@Transactional
	public void save(TreatmentSowing t) {
		dao.save(t);
	}

	@Override
	@Transactional
	public TreatmentSowing findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<TreatmentSowing> findAll() {
		return (List<TreatmentSowing>) dao.findAll();
	}
}
