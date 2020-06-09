package com.system.green.house.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.User;

public interface IUser extends CrudRepository<User, Integer>{

}
