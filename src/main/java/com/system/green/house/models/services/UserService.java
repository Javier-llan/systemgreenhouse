package com.system.green.house.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.green.house.models.dao.IUser;
import com.system.green.house.models.entities.User;

@Service
public class UserService implements IUserService {
	@Autowired 
	private IUser dao;
	
	@Override
	@Transactional
	public void save(User u) {
		dao.save(u);
	}

	@Override
	@Transactional
	public User findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return (List<User>) dao.findAll();
	}

}
