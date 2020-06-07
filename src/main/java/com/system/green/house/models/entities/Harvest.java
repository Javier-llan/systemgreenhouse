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

@Entity
@Table(name="harvests")
public class Harvest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_harvest")
	private Integer idharvest;
	
	@Column(name="date_harvest")
	private Calendar dateHarvest;
	
	@Column(name="lot_box_unclassifield")
	private Integer lotBoxUnclassifield;
	
	@Column(name="lot_firts_class")
	private Integer lotFirtsClass;
	
	@Column(name="lot_second_class")
	private Integer lotSecondClass;
	
	@Column(name="lot_thrid_class")
	private Integer lotThridClass;
	
	@Column(name="lot_box_classifield")
	private Integer lotBoxClassifield;
	
	@Column(name="condition_harvest")
	private Integer conditionHarvest;
	
	@Column(name="commentary_harvest")
	private String commentaryHarvest;
	
	public Harvest() {
		super();
	}
	
	public Harvest(Integer id) {
		super();
		this.idharvest=id;
	}

	public Integer getIdharvest() {
		return idharvest;
	}

	public void setIdharvest(Integer idharvest) {
		this.idharvest = idharvest;
	}

	public Calendar getDateHarvest() {
		return dateHarvest;
	}

	public void setDateHarvest(Calendar dateHarvest) {
		this.dateHarvest = dateHarvest;
	}

	public Integer getLotBoxUnclassifield() {
		return lotBoxUnclassifield;
	}

	public void setLotBoxUnclassifield(Integer lotBoxUnclassifield) {
		this.lotBoxUnclassifield = lotBoxUnclassifield;
	}

	public Integer getLotFirtsClass() {
		return lotFirtsClass;
	}

	public void setLotFirtsClass(Integer lotFirtsClass) {
		this.lotFirtsClass = lotFirtsClass;
	}

	public Integer getLotSecondClass() {
		return lotSecondClass;
	}

	public void setLotSecondClass(Integer lotSecondClass) {
		this.lotSecondClass = lotSecondClass;
	}

	public Integer getLotThridClass() {
		return lotThridClass;
	}

	public void setLotThridClass(Integer lotThridClass) {
		this.lotThridClass = lotThridClass;
	}

	public Integer getLotBoxClassifield() {
		return lotBoxClassifield;
	}

	public void setLotBoxClassifield(Integer lotBoxClassifield) {
		this.lotBoxClassifield = lotBoxClassifield;
	}

	public Integer getConditionHarvest() {
		return conditionHarvest;
	}

	public void setConditionHarvest(Integer conditionHarvest) {
		this.conditionHarvest = conditionHarvest;
	}

	public String getCommentaryHarvest() {
		return commentaryHarvest;
	}

	public void setCommentaryHarvest(String commentaryHarvest) {
		this.commentaryHarvest = commentaryHarvest;
	}
	
	@JoinColumn(name="fk_sowing", referencedColumnName = "pk_sowing")
	@ManyToOne
	private Sowing sowings;

	public Sowing getSowings() {
		return sowings;
	}

	public void setSowings(Sowing sowings) {
		this.sowings = sowings;
	}
	
	
	
}
