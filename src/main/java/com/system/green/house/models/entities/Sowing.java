package com.system.green.house.models.entities;

import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="sowings")
public class Sowing implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_sowing")
	private Integer idsowing;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	@Column(name="date_sowing")
	private Calendar dateSowing;
	
	@Column(name="distance_plants")
	private Integer distancePlants;
	
	@Column(name="quantity_plants")
	private Integer quantityPlants;
	
	@Column(name="condition_sowing")
	private Integer condition_sowing;
	
	@Column(name="commentary_sowing")
	private String commentary_sowing;
	
	
	/**** TRANSIENT ***/
	@Transient
	private int plantid;
	
	public int getPlantid() {
		return plantid;
	}

	public void setPlantid(int plantid) {
		this.plantid = plantid;
	}

	public Sowing() {
		super();
	}
	
	public Sowing(Integer id) {
		super();
		this.idsowing=id;
	}

	public Integer getIdsowing() {
		return idsowing;
	}

	public void setIdsowing(Integer idsowing) {
		this.idsowing = idsowing;
	}

	public Calendar getDateSowing() {
		return dateSowing;
	}

	public void setDateSowing(Calendar dateSowing) {
		this.dateSowing = dateSowing;
	}

	public Integer getDistancePlants() {
		return distancePlants;
	}

	public void setDistancePlants(Integer distancePlants) {
		this.distancePlants = distancePlants;
	}

	public Integer getQuantityPlants() {
		return quantityPlants;
	}

	public void setQuantityPlants(Integer quantityPlants) {
		this.quantityPlants = quantityPlants;
	}

	public Integer getCondition_sowing() {
		return condition_sowing;
	}

	public void setCondition_sowing(Integer condition_sowing) {
		this.condition_sowing = condition_sowing;
	}

	public String getCommentary_sowing() {
		return commentary_sowing;
	}

	public void setCommentary_sowing(String commentary_sowing) {
		this.commentary_sowing = commentary_sowing;
	}
	
	@JoinColumn(name="fk_plant",referencedColumnName = "pk_plant")
	@ManyToOne
	private Plant plants;

	public Plant getPlants() {
		return plants;
	}

	public void setPlants(Plant plants) {
		this.plants = plants;
	}
	
	
	
	
}
