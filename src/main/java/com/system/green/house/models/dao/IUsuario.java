package com.system.green.house.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.system.green.house.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByNombre(String nombre);	

}
