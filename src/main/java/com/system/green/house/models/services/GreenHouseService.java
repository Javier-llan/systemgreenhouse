package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IGreenHouse;
import com.system.green.house.models.entities.GreenHouse;

@Service
public class GreenHouseService implements IGreenHouseService{

	@Autowired 
	private IGreenHouse dao;
	
	@Override
	@Transactional
	public void save(GreenHouse g) {
		dao.save(g);
	}

	@Override
	@Transactional
	public GreenHouse findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<GreenHouse> findAll() {
		return (List<GreenHouse>) dao.findAll();
	}

}
