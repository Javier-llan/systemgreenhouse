package com.system.green.house.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends People implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="name", unique = true)
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name="create_on")
	private Calendar createOn;
	
	public User() {
		super();
	}
	
	public User(Integer id) {
		super();
		this.setIdpeople(id);
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Calendar getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Calendar createOn) {
		this.createOn = createOn;
	}

	@PrePersist
	public void prePersist() {
		createOn=Calendar.getInstance();
		enabled=true;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="pk_user")
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
