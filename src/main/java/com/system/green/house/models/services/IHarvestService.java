package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.Harvest;

public interface IHarvestService {
	public void save(Harvest h);
	public Harvest findById(Integer id);
	public void delete(Integer id);
	public List<Harvest> findAll();
}
