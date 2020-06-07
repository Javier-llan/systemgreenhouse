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
@Table(name="treatments_sowing")
public class TreatmentSowing implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_treatment_swoing")
	private Integer idtreatment_swoing;
	
	@Column(name="date_treatment_sowing")
	private Calendar dateTreatmentsSowing;
	
	@Column(name="description_treatment_sowing")
	private String descriptiontreatmensSowing;
	
	@Column(name="condtion_treatment_sowing")
	private Integer conditionTreatmentsSwoing;
	
	@Column(name="commentary_treatment_sowing")
	private String commentaryTreatmentSowing;
	
	public TreatmentSowing() {
		super();
	}
	
	public TreatmentSowing(Integer id) {
		super();
		this.idtreatment_swoing=id;
	}

	public Integer getIdtreatment_swoing() {
		return idtreatment_swoing;
	}

	public void setIdtreatment_swoing(Integer idtreatment_swoing) {
		this.idtreatment_swoing = idtreatment_swoing;
	}

	public Calendar getDateTreatmentsSowing() {
		return dateTreatmentsSowing;
	}

	public void setDateTreatmentsSowing(Calendar dateTreatmentsSowing) {
		this.dateTreatmentsSowing = dateTreatmentsSowing;
	}

	public String getDescriptiontreatmensSowing() {
		return descriptiontreatmensSowing;
	}

	public void setDescriptiontreatmensSowing(String descriptiontreatmensSowing) {
		this.descriptiontreatmensSowing = descriptiontreatmensSowing;
	}

	public Integer getConditionTreatmentsSwoing() {
		return conditionTreatmentsSwoing;
	}

	public void setConditionTreatmentsSwoing(Integer conditionTreatmentsSwoing) {
		this.conditionTreatmentsSwoing = conditionTreatmentsSwoing;
	}

	public String getCommentaryTreatmentSowing() {
		return commentaryTreatmentSowing;
	}

	public void setCommentaryTreatmentSowing(String commentaryTreatmentSowing) {
		this.commentaryTreatmentSowing = commentaryTreatmentSowing;
	}
	
	@JoinColumn(name="fk_sowing",referencedColumnName = "pk_sowing")
	@ManyToOne
	private Sowing sowing;

	public Sowing getSowings() {
		return sowing;
	}

	public void setSowings(Sowing sowings) {
		this.sowing = sowings;
	}
		
}
