package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.ChemicalUsed;

public interface IChemicalUsedService {
	public void save(ChemicalUsed ch);
	public ChemicalUsed findById(Integer id);
	public void delete(Integer id);
	public List<ChemicalUsed> findAll();
}
