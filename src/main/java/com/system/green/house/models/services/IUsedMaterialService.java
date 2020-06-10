package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.UsedMaterial;

public interface IUsedMaterialService {
	public void save(UsedMaterial u);
	public UsedMaterial findById(Integer id);
	public void delete(Integer id);
	public List<UsedMaterial> findAll();
}
