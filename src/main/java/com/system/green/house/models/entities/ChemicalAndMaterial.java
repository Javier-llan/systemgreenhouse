package com.system.green.house.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="chemical_and_materials")
public class ChemicalAndMaterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_chemical_material")
	private Integer idchemicalAndMaterial;
	
	@Column(name="type_material")
	private String typeMaterial;
	
	@Column(name="name_material")
	private String nameMaterial;
	
	@Column(name="description_material")
	private String descriptionMaterial;
	
	@Column(name="quantity_material")
	private String quantityMaterial;
	
	@Column(name="unit_measure")
	private String unitMeasue;
	
	@Column(name="price_buy")
	private Double priceBuy;
	
	@Column(name = "image_chemicalmaterial")
	private String image_chemicalmaterial;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	@Column(name="date_buy")
	private Calendar dateBuy;
	
	@Column(name="condition_stock")
	private Integer conditionStock;
	
	@Column(name="commentary")
	private String commentary;
	
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;

	@Column(name = "creado_por")
	private String creadoPor;

	@Column(name = "modificado_en")
	private LocalDateTime modificadoEn;

	@Column(name = "modificado_por")
	private String modificadoPor;
	
	
	
	public ChemicalAndMaterial() {
		super();
		
	}
	
	public ChemicalAndMaterial(Integer id) {
		super();
		this.idchemicalAndMaterial=id;
	}

	
	public Integer getIdchemicalAndMaterial() {
		return idchemicalAndMaterial;
	}

	public void setIdchemicalAndMaterial(Integer idchemicalAndMaterial) {
		this.idchemicalAndMaterial = idchemicalAndMaterial;
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

	
	public String getUnitMeasue() {
		return unitMeasue;
	}

	public void setUnitMeasue(String unitMeasue) {
		this.unitMeasue = unitMeasue;
	}

	public String getImage_chemicalmaterial() {
		return image_chemicalmaterial;
	}

	public void setImage_chemicalmaterial(String image_chemicalmaterial) {
		this.image_chemicalmaterial = image_chemicalmaterial;
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
	@OneToMany(mappedBy="materialsGreenHouse", fetch=FetchType.LAZY)
	private List<UsedMaterial>usedMaterial;

	public List<UsedMaterial> getUsedMaterial() {
		return usedMaterial;
	}

	public void setUsedMaterial(List<UsedMaterial> usedMaterial) {
		this.usedMaterial = usedMaterial;
	}

	@JsonIgnore
	@OneToMany(mappedBy="material", fetch=FetchType.LAZY)
	private List<ChemicalUsed>chemicalUsed;

	public List<ChemicalUsed> getChemicalUsed() {
		return chemicalUsed;
	}

	public void setChemicalUsed(List<ChemicalUsed> chemicalUsed) {
		this.chemicalUsed = chemicalUsed;
	}

	

		
}
