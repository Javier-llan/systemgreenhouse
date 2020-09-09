package com.system.green.house.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name="useds_materials")
public class UsedMaterial implements Serializable{
 
	private static final long serialVersionUID = 1L;
	/** Atributos **/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_used_material")
	private Integer idMaterialUsed;
	
	@Column(name="quantity_used")
	private Integer quantityUsed;
	
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;

	@Column(name = "creado_por")
	private String creadoPor;

	@Column(name = "modificado_en")
	private LocalDateTime modificadoEn;

	@Column(name = "modificado_por")
	private String modificadoPor;
	
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
	
	
	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public LocalDateTime getModificadoEn() {
		return modificadoEn;
	}

	public void setModificadoEn(LocalDateTime modificadoEn) {
		this.modificadoEn = modificadoEn;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}


	/** Relaciones entre tablas */
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
	
	/**Transient **/
	@Transient
	private int maintenanceid;
	
	@Transient
	private int materialid;

	public int getMaintenanceid() {
		return maintenanceid;
	}

	public void setMaintenanceid(int maintenanceid) {
		this.maintenanceid = maintenanceid;
	}

	public int getMaterialid() {
		return materialid;
	}

	public void setMaterialid(int materialid) {
		this.materialid = materialid;
	}
	
	@PrePersist
	public void prePersist() {
		creadoEn = LocalDateTime.now();
		SecurityContext context = SecurityContextHolder.getContext();
        creadoPor = context.getAuthentication().getName();
	}

	@PreUpdate
	public void preUpdate() {
		modificadoEn = LocalDateTime.now();
		SecurityContext context = SecurityContextHolder.getContext();
        modificadoPor = context.getAuthentication().getName();
	}
	
}
