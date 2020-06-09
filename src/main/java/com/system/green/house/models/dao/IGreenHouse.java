package com.system.green.house.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.GreenHouse;

public interface IGreenHouse extends CrudRepository<GreenHouse, Integer>{

}
