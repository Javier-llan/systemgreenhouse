package com.system.green.house.models.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.Sowing;



public interface ISowing extends CrudRepository<Sowing, Integer>{

	@Query("SELECT S FROM Sowing S WHERE S.plants.idplant = :id")	
	public List<Sowing> findByPlant(Integer id);
	
}
