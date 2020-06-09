package com.system.green.house.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.Material;

public interface IMaterial extends CrudRepository<Material, Integer>{

}
