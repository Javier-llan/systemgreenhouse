package com.system.green.house.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptPlantsSowing implements Serializable {

private static final long serialVersionUID = 1L;
	
	
	private String planta;
	private Integer siembras;
	

	public RptPlantsSowing(String planta, Integer siembras) {
		super();
		this.planta = planta;
		this.siembras = siembras;
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

	public Integer getSiembras() {
		return siembras;
	}

	public void setSiembras(Integer siembras) {
		this.siembras = siembras;
	}

	
	
	
	
}
