package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IPlant;
import com.system.green.house.models.entities.Plant;

@Service
public class PlantService implements IPlantService {

	@Autowired 
	private IPlant dao;
	
	@Override
	@Transactional
	public void save(Plant p) {
		dao.save(p);
	}

	@Override
	@Transactional
	public Plant findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Plant> findAll() {
		return (List<Plant>) dao.findAll();
	}

}
