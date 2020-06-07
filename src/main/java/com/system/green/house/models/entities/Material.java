package com.system.green.house.models.entities;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name="materials")
public class Material implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_material")
	private Integer idmaterial;
	
	@Column(name="type_material")
	private String typeMaterial;
	
	@Column(name="name_material")
	private String nameMaterial;
	
	@Column(name="description_material")
	private String descriptionMaterial;
	
	@Column(name="quantity_material")
	private String quantityMaterial;
	
	@Column(name="price_buy")
	private Double priceBuy;
	
	@Column(name="date_buy")
	private Calendar dateBuy;
	
	@Column(name="condition_stock")
	private Integer conditionStock;
	
	@Column(name="commentary")
	private String commentary;
	
	public Material() {
		super();
		
	}
	
	public Material(Integer id) {
		super();
		this.idmaterial=id;
	}

	public Integer getIdmaterial() {
		return idmaterial;
	}

	public void setIdmaterial(Integer idmaterial) {
		this.idmaterial = idmaterial;
	}

	public String getTypeMaterial() {
		return typeMaterial;
	}

	public void setTypeMaterial(String typeMaterial) {
		this.typeMaterial = typeMaterial;
	}

	public String getNameMaterial() {
		return nameMaterial;
	}

	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}

	public String getDescriptionMaterial() {
		return descriptionMaterial;
	}

	public void setDescriptionMaterial(String descriptionMaterial) {
		this.descriptionMaterial = descriptionMaterial;
	}

	public String getQuantityMaterial() {
		return quantityMaterial;
	}

	public void setQuantityMaterial(String quantityMaterial) {
		this.quantityMaterial = quantityMaterial;
	}

	public Double getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(Double priceBuy) {
		this.priceBuy = priceBuy;
	}

	public Calendar getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(Calendar dateBuy) {
		this.dateBuy = dateBuy;
	}

	public Integer getConditionStock() {
		return conditionStock;
	}

	public void setConditionStock(Integer conditionStock) {
		this.conditionStock = conditionStock;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	
	@OneToMany(mappedBy="material", fetch=FetchType.LAZY)
	private List<UsedMaterial>usedMaterial;

	public List<UsedMaterial> getUsedMaterial() {
		return usedMaterial;
	}

	public void setUsedMaterial(List<UsedMaterial> usedMaterial) {
		this.usedMaterial = usedMaterial;
	}

		
}
