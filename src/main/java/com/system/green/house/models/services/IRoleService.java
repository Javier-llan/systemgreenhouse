package com.system.green.house.models.services;

import java.util.List;

import com.system.green.house.models.entities.Role;

public interface IRoleService {
	public void save(Role r);
	public Role findById(Integer id);
	public void delete(Integer id);
	public List<Role> findAll();
}
