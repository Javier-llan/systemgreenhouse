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

import com.system.green.house.models.dao.ISowing;
import com.system.green.house.models.entities.Sowing;
import com.system.green.house.models.reporting.RptPlantsSowing;




@Service
public class SowingService implements ISowingService{
	@Autowired 
	private ISowing dao;
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	@Transactional
	public void save(Sowing s) {
		dao.save(s);
	}

	@Override
	@Transactional
	public Sowing findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Sowing> findAll() {
		return (List<Sowing>) dao.findAll();
	}
	
	

	
	
	@Override
	@Transactional
	public List<Sowing> findByPlant(Integer id) {
		try {
			List<Sowing> resultado = dao.findByPlant(id);
			return resultado;
		}
		catch(Exception ex) {
			System.out.println("Error =>" + ex.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public List<RptPlantsSowing> rptPlantadosSiembra() {
		StoredProcedureQuery query = em.createStoredProcedureQuery("reporte_plants_sowing");
		query.execute();
		List<Object[]> datos = query.getResultList();		
		return datos.stream()
				.map(r -> new RptPlantsSowing((String)r[0], (BigInteger)r[1]))
				.collect(Collectors.toList());	
		
	}

}
