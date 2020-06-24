package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.green.house.models.dao.IChemicalUsed;
import com.system.green.house.models.entities.ChemicalUsed;

@Service
public class ChemicalUsedService implements IChemicalUsedService{

	@Autowired
	private IChemicalUsed dao;
	
	@Override
	public void save(ChemicalUsed ch) {
		// TODO Auto-generated method stub
		dao.save(ch);
	}

	@Override
	public ChemicalUsed findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<ChemicalUsed> findAll() {
		// TODO Auto-generated method stub
		return (List<ChemicalUsed>) dao.findAll();
	}

}
