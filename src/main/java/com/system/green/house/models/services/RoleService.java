package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IRole;
import com.system.green.house.models.entities.Role;

@Service
public class RoleService implements IRoleService{
	@Autowired 
	private IRole dao;
	
	@Override
	@Transactional
	public void save(Role r) {
		dao.save(r);
	}

	@Override
	@Transactional
	public Role findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Role> findAll() {
		return (List<Role>) dao.findAll();
	}

}
