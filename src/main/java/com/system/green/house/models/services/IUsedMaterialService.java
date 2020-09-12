package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.UsedMaterial;
import com.system.green.house.models.reporting.RptPlantsSowing;
import com.system.green.house.models.reporting.RptUsedsMaterials;
import com.system.green.house.models.reporting.RptUserMaintenanceCreadoPor;

public interface IUsedMaterialService {
	public void save(UsedMaterial u);
	public UsedMaterial findById(Integer id);
	public void delete(Integer id);
	public List<UsedMaterial> findAll();
	public List<RptUserMaintenanceCreadoPor> rptUserMaintenanceCreadoPors();
	public List<RptUsedsMaterials> rptMaterialesUsados();
}
