package com.system.green.house.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

import com.system.green.house.models.entities.GreenHouse;

public class RptGreenHouseUsedMaterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipomaterial;
	private Integer cantidad;
	
	public RptGreenHouseUsedMaterial(Integer id, String tipomaterial, Integer cantidad) {
		super();
		this.id=id;
		this.tipomaterial=tipomaterial;
		this.cantidad=cantidad;
	}
	
	 public RptGreenHouseUsedMaterial() {
		 super();
	 }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipomaterial() {
		return tipomaterial;
	}
	public void setTipomaterial(String tipomaterial) {
		this.tipomaterial = tipomaterial;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	 
	 
}
