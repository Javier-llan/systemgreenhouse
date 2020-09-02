package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.Plant;



public interface IPlantService {
	public void save(Plant p);
	public Plant findById(Integer id);
	public void delete(Integer id);
	public List<Plant> findAll();
	
}
