package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.GreenHouse;


public interface IGreenHouseService {
	public void save(GreenHouse g);
	public GreenHouse findById(Integer id);
	public void delete(Integer id);
	public List<GreenHouse> findAll();
	public List<GreenHouse> findByInvernadero(Integer id);
}
