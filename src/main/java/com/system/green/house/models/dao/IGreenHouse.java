package com.system.green.house.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.GreenHouse;


public interface IGreenHouse extends CrudRepository<GreenHouse, Integer>{
	
	@Query("SELECT G FROM GreenHouse G WHERE G.conditionGreenHouse = :c")	
	public List<GreenHouse> findByInvernadero(Integer c);

}
