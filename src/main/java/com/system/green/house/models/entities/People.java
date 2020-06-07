package com.system.green.house.models.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class  People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	
	@Column(name="pk_people")
	private Integer idpeople;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="cell_phone")
	private String cellPhone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="addres")
	private String addres;
	
	public People() {
		super();
	}
	
	public People(Integer id) {
		super();
		this.idpeople=id;
	}
	
	

	public Integer getIdpeople() {
		return idpeople;
	}

	public void setIdpeople(Integer idpeople) {
		this.idpeople = idpeople;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		
		return this.getLastName()+" "+this.getName();
	}
}
