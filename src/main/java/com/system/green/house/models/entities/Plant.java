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
@Table(name="plants")
public class Plant implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_plant")
	private Integer idplant;
	
	@Column(name="name_plant")
	private String namePlant;
	
	@Column(name="type_plant")
	private String typePlant;
	
	@Column(name="variety_plant")
	private String varietyPlant;
	
	@Column(name="condition_plant")
	private Integer conditionPlant;
	
	@Column(name="description_plant")
	private String descriptionPlant;
	
	@Column(name="commentary")
	private String commentary;
	
	public Plant() {
		super();
	}
	
	public Plant(Integer id) {
		super();
		this.idplant=id;
	}

	public Integer getIdplant() {
		return idplant;
	}

	public void setIdplant(Integer idplant) {
		this.idplant = idplant;
	}

	public String getNamePlant() {
		return namePlant;
	}

	public void setNamePlant(String namePlant) {
		this.namePlant = namePlant;
	}

	public String getTypePlant() {
		return typePlant;
	}

	public void setTypePlant(String typePlant) {
		this.typePlant = typePlant;
	}

	public String getVarietyPlant() {
		return varietyPlant;
	}

	public void setVarietyPlant(String varietyPlant) {
		this.varietyPlant = varietyPlant;
	}

	public Integer getConditionPlant() {
		return conditionPlant;
	}

	public void setConditionPlant(Integer conditionPlant) {
		this.conditionPlant = conditionPlant;
	}

	public String getDescriptionPlant() {
		return descriptionPlant;
	}

	public void setDescriptionPlant(String descriptionPlant) {
		this.descriptionPlant = descriptionPlant;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	@OneToMany(mappedBy="plants",fetch=FetchType.LAZY)
	private List<Sowing> sowing;

	public List<Sowing> getSowing() {
		return sowing;
	}

	public void setSowing(List<Sowing> sowing) {
		this.sowing = sowing;
	}
	
	
	
	
}
