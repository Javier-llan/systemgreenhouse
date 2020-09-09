package com.system.green.house.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="maintenances_green_house")
public class MaintenanceGreenHouse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_maintenance_green_house")
	private Integer idMaintenaceGreenHouse;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	@Column(name="date_maintenance_green_house")
	private Calendar dateMaintenanceGreenHouse;
	
	@Column(name="description_maintenace_green_house")
	private String descriptionMaintenaceGreenHouse;
	
	@Column(name="condition_maintenace_green_house")
	private Integer conditionMaintenanceGreenHouse;
	
	@Column(name="commentary_maintenace_green_house")
	private String commentarMaintenanceGreenHouse;
	
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;

	@Column(name = "creado_por")
	private String creadoPor;

	@Column(name = "modificado_en")
	private LocalDateTime modificadoEn;

	@Column(name = "modificado_por")
	private String modificadoPor;
	
	public MaintenanceGreenHouse() {
		super();
	}
	
	public MaintenanceGreenHouse(Integer id) {
		super();
		this.idMaintenaceGreenHouse=id;
	}

	public Integer getIdMaintenaceGreenHouse() {
		return idMaintenaceGreenHouse;
	}

	public void setIdMaintenaceGreenHouse(Integer idMaintenaceGreenHouse) {
		this.idMaintenaceGreenHouse = idMaintenaceGreenHouse;
	}

	public Calendar getDateMaintenanceGreenHouse() {
		return dateMaintenanceGreenHouse;
	}

	public void setDateMaintenanceGreenHouse(Calendar dateMaintenanceGreenHouse) {
		this.dateMaintenanceGreenHouse = dateMaintenanceGreenHouse;
	}

	public String getDescriptionMaintenaceGreenHouse() {
		return descriptionMaintenaceGreenHouse;
	}

	public void setDescriptionMaintenaceGreenHouse(String descriptionMaintenaceGreenHouse) {
		this.descriptionMaintenaceGreenHouse = descriptionMaintenaceGreenHouse;
	}

	public Integer getConditionMaintenanceGreenHouse() {
		return conditionMaintenanceGreenHouse;
	}

	public void setConditionMaintenanceGreenHouse(Integer conditionMaintenanceGreenHouse) {
		this.conditionMaintenanceGreenHouse = conditionMaintenanceGreenHouse;
	}

	public String getCommentarMaintenanceGreenHouse() {
		return commentarMaintenanceGreenHouse;
	}

	public void setCommentarMaintenanceGreenHouse(String commentarMaintenanceGreenHouse) {
		this.commentarMaintenanceGreenHouse = commentarMaintenanceGreenHouse;
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


	@JsonIgnore
	@OneToMany(mappedBy="maintenancesGreenHouse", fetch=FetchType.LAZY)
	private List<UsedMaterial> usedMaterial;

	public List<UsedMaterial> getUsedMaterial() {
		if(usedMaterial == null) {
			usedMaterial = new ArrayList<UsedMaterial>();
		}
		return usedMaterial;
	}

	public void setUsedMaterial(List<UsedMaterial> usedMaterial) {
		this.usedMaterial = usedMaterial;
	}

	@JoinColumn(name="fk_green_house",referencedColumnName = "pk_green_house")
	@ManyToOne
	private GreenHouse greenHouse;

	public GreenHouse getGreenHouse() {
		return greenHouse;
	}

	public void setGreenHouse(GreenHouse greenHouse) {
		this.greenHouse = greenHouse;
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

