package com.system.green.house.models.services;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IUsedMaterial;
import com.system.green.house.models.entities.UsedMaterial;
import com.system.green.house.models.reporting.RptGreenHouseUsedMaterial;
import com.system.green.house.models.reporting.RptUsedsMaterials;
import com.system.green.house.models.reporting.RptUserMaintenanceCreadoPor;

@Service
public class UsedMaterialService implements IUsedMaterialService{
	@Autowired 
	private IUsedMaterial dao;
	
	@PersistenceContext
	private EntityManager em;
	
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

	@Override
	public List<RptUserMaintenanceCreadoPor> rptUserMaintenanceCreadoPors() {
		StoredProcedureQuery query = em.createStoredProcedureQuery("mantenimiento_creado_por");
		query.execute();
		List<Object[]> datos = query.getResultList();
		return datos.stream()
				.map(r-> new RptUserMaintenanceCreadoPor((String)r[0],(String)r[1],(BigInteger)r[2]))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<RptUsedsMaterials> rptMaterialesUsados() {
		StoredProcedureQuery query = em.createStoredProcedureQuery("reporte_material_usado");
		query.execute();
		List<Object[]> datos = query.getResultList();		
		return datos.stream()
				.map(r -> new RptUsedsMaterials((String)r[0], (Double)r[1]))
				.collect(Collectors.toList());	
		
	}
	@Override
	public List<RptGreenHouseUsedMaterial> rptGreenHouseUsedMaterials(){
		StoredProcedureQuery query = em.createStoredProcedureQuery("reporte_invernadero_cantidad_usada");
		query.execute();
		List<Object[]> datos = query.getResultList();		
		return datos.stream()
				.map(r -> new RptGreenHouseUsedMaterial((String)r[0], (String)r[1],(Integer)r[2]))
				.collect(Collectors.toList());	
	}
}
