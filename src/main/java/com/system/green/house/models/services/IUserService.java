package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.User;

public interface IUserService {
	public void save(User u);
	public User findById(Integer id);
	public void delete(Integer id);
	public List<User> findAll();
}
