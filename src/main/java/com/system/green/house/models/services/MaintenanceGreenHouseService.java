package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IMaintenanceGreenHouse;
import com.system.green.house.models.entities.MaintenanceGreenHouse;

@Service
public class MaintenanceGreenHouseService implements IMaintenanceGreenHouseService{

	@Autowired 
	private IMaintenanceGreenHouse dao;
	
	@Override
	@Transactional
	public void save(MaintenanceGreenHouse m) {
		dao.save(m);
	}

	@Override
	@Transactional
	public MaintenanceGreenHouse findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<MaintenanceGreenHouse> findAll() {
		return (List<MaintenanceGreenHouse>) dao.findAll();
	}

}
