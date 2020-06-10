package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IHarvest;
import com.system.green.house.models.entities.Harvest;

@Service
public class HarvestService implements IHarvestService{
	
	@Autowired 
	private IHarvest dao;
	
	@Override
	@Transactional
	public void save(Harvest h) {
		dao.save(h);
	}

	@Override
	@Transactional
	public Harvest findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Harvest> findAll() {
		return (List<Harvest>) dao.findAll();
	}

	
}
