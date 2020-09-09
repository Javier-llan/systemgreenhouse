package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IChemicalAndMaterial;
import com.system.green.house.models.entities.ChemicalAndMaterial;

@Service
public class ChemicalAndMaterialService implements IChemicalAndMaterialService{
	
	@Autowired 
	private IChemicalAndMaterial dao;
	
	@Override
	@Transactional
	public void save(ChemicalAndMaterial m) {
		dao.save(m);
	}

	@Override
	@Transactional
	public ChemicalAndMaterial findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<ChemicalAndMaterial> findAll() {
		return (List<ChemicalAndMaterial>) dao.findAll();
	}
	
	@Override
	@Transactional
	public List<ChemicalAndMaterial> findByName(String materialName){
		return dao.findByName(materialName);
	}

}
