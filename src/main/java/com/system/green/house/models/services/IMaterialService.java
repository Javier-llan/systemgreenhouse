package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.Material;

public interface IMaterialService {
	public void save(Material m);
	public Material findById(Integer id);
	public void delete(Integer id);
	public List<Material> findAll();
}
