package com.system.green.house.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.Harvest;

public interface IHarvest extends CrudRepository<Harvest, Integer> {

}
