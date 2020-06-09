package com.system.green.house.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.Plant;

public interface IPlant extends CrudRepository<Plant, Integer>{

}
