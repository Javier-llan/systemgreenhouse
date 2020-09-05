package com.system.green.house.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptPlantsSowing implements Serializable {

private static final long serialVersionUID = 1L;
	
	
	private String planta;
	private BigInteger cantidad_siembras;
	

	public RptPlantsSowing(String planta, BigInteger cantidad_siembras) {
		super();
		this.planta = planta;
		this.cantidad_siembras = cantidad_siembras;
	}

	public RptPlantsSowing() {
		super();
	}

	public String getNombre_planta() {
		return planta;
	}

	public void setNombre_planta(String planta) {
		this.planta = planta;
	}

	public BigInteger getCantidad_siembras() {
		return cantidad_siembras;
	}

	public void setCantidad_siembras(BigInteger cantidad_siembras) {
		this.cantidad_siembras = cantidad_siembras;
	}



	
	
	
	
}
