package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.ISowing;
import com.system.green.house.models.entities.Sowing;

@Service
public class SowingService implements ISowingService{
	@Autowired 
	private ISowing dao;
	
	@Override
	@Transactional
	public void save(Sowing s) {
		dao.save(s);
	}

	@Override
	@Transactional
	public Sowing findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Sowing> findAll() {
		return (List<Sowing>) dao.findAll();
	}

}
