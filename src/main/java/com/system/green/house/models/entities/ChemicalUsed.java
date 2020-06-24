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
@Table(name="chemicals_useds")
public class ChemicalUsed implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_chemical_used")
	private Integer idChemicalUsed;
	
	@Column(name="quantity_supply")
	private Double quantitySupply;
	
	public ChemicalUsed() {
		super();
	}
	
	public ChemicalUsed(Integer id) {
		super();
		this.idChemicalUsed=id;
	}

	public Integer getIdChemicalUsed() {
		return idChemicalUsed;
	}

	public void setIdChemicalUsed(Integer idChemicalUsed) {
		this.idChemicalUsed = idChemicalUsed;
	}

	public Double getQuantitySupply() {
		return quantitySupply;
	}

	public void setQuantitySupply(Double quantitySupply) {
		this.quantitySupply = quantitySupply;
	}
	
	@JoinColumn(name="fk_chemical_material", referencedColumnName="pk_chemical_material")
	@ManyToOne
	private ChemicalAndMaterial material;

	public ChemicalAndMaterial getMaterials() {
		return material;
	}

	public void setMaterials(ChemicalAndMaterial materials) {
		this.material = materials;
	}
	
	@JoinColumn(name="fk_treatment_swoing",referencedColumnName="pk_treatment_swoing")
	@ManyToOne
	private TreatmentSowing treatmentSowings;

	public ChemicalAndMaterial getMaterial() {
		return material;
	}

	public void setMaterial(ChemicalAndMaterial material) {
		this.material = material;
	}

	public TreatmentSowing getTreatmenSowings() {
		return treatmentSowings;
	}

	public void setTreatmenSowings(TreatmentSowing treatmenSowings) {
		this.treatmentSowings = treatmenSowings;
	}
	
	
}
