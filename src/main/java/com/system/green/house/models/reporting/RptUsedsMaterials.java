package com.system.green.house.models.reporting;

import java.io.Serializable;


public class RptUsedsMaterials implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Double cantidad;
	public RptUsedsMaterials(String nombre, Double cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public RptUsedsMaterials() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	

	

	


}
