package com.system.green.house.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.ChemicalAndMaterial;

public interface IChemicalAndMaterial extends CrudRepository<ChemicalAndMaterial, Integer>{

	@Query("SELECT M FROM ChemicalAndMaterial M WHERE LOWER(M.nameMaterial) LIKE CONCAT('%',?1,'%')")
	public List<ChemicalAndMaterial> findByName(String materialName);
}
