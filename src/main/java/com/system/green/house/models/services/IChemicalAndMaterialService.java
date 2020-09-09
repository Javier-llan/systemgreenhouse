package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.ChemicalAndMaterial;

public interface IChemicalAndMaterialService {
	public void save(ChemicalAndMaterial m);
	public ChemicalAndMaterial findById(Integer id);
	public void delete(Integer id);
	public List<ChemicalAndMaterial> findAll();
	public List<ChemicalAndMaterial> findByName(String materialName);
}
