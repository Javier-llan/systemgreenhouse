package com.system.green.house.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

import com.system.green.house.models.entities.GreenHouse;

public class RptGreenHouseUsedMaterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String tipomaterial;
	private Integer cantidad;
	
	 public RptGreenHouseUsedMaterial(String nombre, String tipomaterial, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.tipomaterial = tipomaterial;
		this.cantidad = cantidad;
	}
	public RptGreenHouseUsedMaterial() {
		 super();
	 }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
