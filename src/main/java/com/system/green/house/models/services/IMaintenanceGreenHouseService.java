package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.MaintenanceGreenHouse;

public interface IMaintenanceGreenHouseService {
	public void save(MaintenanceGreenHouse m);
	public MaintenanceGreenHouse findById(Integer id);
	public void delete(Integer id);
	public List<MaintenanceGreenHouse> findAll();

}
