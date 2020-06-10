package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IUsedMaterial;
import com.system.green.house.models.entities.UsedMaterial;

@Service
public class UsedMaterialService implements IUsedMaterialService{
	@Autowired 
	private IUsedMaterial dao;
	
	@Override
	@Transactional
	public void save(UsedMaterial u) {
		dao.save(u);
	}

	@Override
	@Transactional
	public UsedMaterial findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<UsedMaterial> findAll() {
		return (List<UsedMaterial>) dao.findAll();
	}
}
