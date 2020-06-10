package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.TreatmentSowing;

public interface ITreatmentSowingService {
	public void save(TreatmentSowing t);
	public TreatmentSowing findById(Integer id);
	public void delete(Integer id);
	public List<TreatmentSowing> findAll();
}
