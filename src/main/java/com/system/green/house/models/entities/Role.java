package com.system.green.house.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_role")
	private Integer idrole;
	
	@Column(name="role_name")
	private String name;
	
	public Role() {
		super();
	}
	
	public Role(Integer id) {
		super();
		this.idrole=id;
		
	}

	public Integer getIdrole() {
		return idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
