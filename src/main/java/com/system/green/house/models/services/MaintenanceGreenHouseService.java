package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IMaintenanceGreenHouse;
import com.system.green.house.models.dao.IUsedMaterial;
import com.system.green.house.models.entities.MaintenanceGreenHouse;
import com.system.green.house.models.entities.UsedMaterial;

@Service
public class MaintenanceGreenHouseService implements IMaintenanceGreenHouseService{

	@Autowired 
	private IMaintenanceGreenHouse dao;
	
	@Autowired
	private IUsedMaterial daousedMaterials;
	
	public void save(MaintenanceGreenHouse maintenance) {
		try {
			dao.save(maintenance);
			for(UsedMaterial usedMaterials: maintenance.getUsedMaterial()) {
				usedMaterials.setMaintenancesGreenHouse(maintenance);
				this.daousedMaterials.save(usedMaterials);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		}
	}
	
	@Transactional
	public MaintenanceGreenHouse findById(Integer id) {
		return dao.findById(id).get();
	}
	
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	@Transactional
	public List<MaintenanceGreenHouse> findAll(){
		return (List<MaintenanceGreenHouse>) dao.findAll();
	}

}
