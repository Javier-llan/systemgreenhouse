package com.system.green.house.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="useds_materials")
public class UsedMaterial implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_used_material")
	private Integer idMaterialUsed;
	
	@Column(name="quantity_used")
	private Integer quantityUsed;
	
	public UsedMaterial() {
		super();
	}
	
	public UsedMaterial(Integer id) {
		super();
		this.idMaterialUsed=id;
	}

	public Integer getIdMaterialUsed() {
		return idMaterialUsed;
	}

	public void setIdMaterialUsed(Integer idMaterialUsed) {
		this.idMaterialUsed = idMaterialUsed;
	}

	public Integer getQuantityUsed() {
		return quantityUsed;
	}

	public void setQuantityUsed(Integer quantityUsed) {
		this.quantityUsed = quantityUsed;
	}
	
	@JoinColumn(name="fk_chemical_material", referencedColumnName="pk_chemical_material")
	@ManyToOne
	private ChemicalAndMaterial materialsGreenHouse;
	
	public ChemicalAndMaterial getMaterialsGreenHouse() {
		return materialsGreenHouse;
	}

	public void setMaterialsGreenHouse(ChemicalAndMaterial materialsGreenHouse) {
		this.materialsGreenHouse = materialsGreenHouse;
	}

	@JoinColumn(name="fk_maintenance_green_house",referencedColumnName="pk_maintenance_green_house")
	@ManyToOne
	private MaintenanceGreenHouse maintenancesGreenHouse;

	public MaintenanceGreenHouse getMaintenancesGreenHouse() {
		return maintenancesGreenHouse;
	}

	public void setMaintenancesGreenHouse(MaintenanceGreenHouse maintenancesGreenHouse) {
		this.maintenancesGreenHouse = maintenancesGreenHouse;
	}
	
}
