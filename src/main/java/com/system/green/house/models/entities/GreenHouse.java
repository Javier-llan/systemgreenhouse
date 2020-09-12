package com.system.green.house.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="green_houses")
public class GreenHouse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_green_house")
	private Integer idgreenHouse;
	
	@Column(name="name_green_house")
	private String nameGreenHouse;
	
	@Column(name="dimension_green_house")
	private Double dimensionGreenHouse;
	
	@Column(name="condition_green_house")
	private String conditionGreenHouse;
	
	@Column(name="caliber_ceiling_lateral")
	private Integer caliberCeilingLateral;
	
	@Column(name="caliber_canal")
	private Integer caliberCanal;
	
	@Column(name="commentary_green_house")
	private String commentary;
	
	public GreenHouse() {
		super();
	}
	
	public GreenHouse(Integer id) {
		super();
		this.idgreenHouse=id;
	}

	public Integer getIdgreenHouse() {
		return idgreenHouse;
	}

	public void setIdgreenHouse(Integer idgreenHouse) {
		this.idgreenHouse = idgreenHouse;
	}

	public String getNameGreenHouse() {
		return nameGreenHouse;
	}

	public void setNameGreenHouse(String nameGreenHouse) {
		this.nameGreenHouse = nameGreenHouse;
	}

	public Double getDimensionGreenHouse() {
		return dimensionGreenHouse;
	}

	public void setDimensionGreenHouse(Double dimensioGreenHouse) {
		this.dimensionGreenHouse = dimensioGreenHouse;
	}

	public String getConditionGreenHouse() {
		return conditionGreenHouse;
	}

	public void setConditionGreenHouse(String conditionGreenHouse) {
		this.conditionGreenHouse = conditionGreenHouse;
	}

	public Integer getCaliberCeilingLateral() {
		return caliberCeilingLateral;
	}

	public void setCaliberCeilingLateral(Integer caliberCeilingLateral) {
		this.caliberCeilingLateral = caliberCeilingLateral;
	}

	public Integer getCaliberCanal() {
		return caliberCanal;
	}

	public void setCaliberCanal(Integer caliberCanal) {
		this.caliberCanal = caliberCanal;
	}

	
	
	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

    

	@OneToMany(mappedBy="greenHouse", fetch=FetchType.LAZY)
	private List<MaintenanceGreenHouse> maintenancesGreenHouse;

	public List<MaintenanceGreenHouse> getMaintenancesGreenHouse() {
		return maintenancesGreenHouse;
	}

	public void setMaintenancesGreenHouse(List<MaintenanceGreenHouse> maintenancesGreenHouse) {
		this.maintenancesGreenHouse = maintenancesGreenHouse;
	}
	
	
	
	
	
	
}
