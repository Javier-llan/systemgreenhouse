package com.system.green.house.models.services;

import java.util.List;


import com.system.green.house.models.entities.Sowing;
import com.system.green.house.models.reporting.RptPlantsSowing;



public interface ISowingService {
	public void save(Sowing s);
	public Sowing findById(Integer id);
	public void delete(Integer id);
	public List<Sowing> findAll();
	public List<Sowing> findByPlant(Integer id);
	public List<RptPlantsSowing> rptPlantadosSiembra();
	
}
