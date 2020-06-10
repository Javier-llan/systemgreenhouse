package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IMaterial;
import com.system.green.house.models.entities.Material;

@Service
public class MaterialService implements IMaterialService{
	@Autowired 
	private IMaterial dao;
	
	@Override
	@Transactional
	public void save(Material m) {
		dao.save(m);
	}

	@Override
	@Transactional
	public Material findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Material> findAll() {
		return (List<Material>) dao.findAll();
	}

}
