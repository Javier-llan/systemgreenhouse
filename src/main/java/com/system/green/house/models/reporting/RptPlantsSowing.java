package com.system.green.house.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptPlantsSowing implements Serializable {

private static final long serialVersionUID = 1L;
	
	
	private String planta;
	private BigInteger siembras;
	

	public RptPlantsSowing(String planta, BigInteger siembras) {
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

	public BigInteger getSiembras() {
		return siembras;
	}

	public void setSiembras(BigInteger siembras) {
		this.siembras = siembras;
	}

	
	
	
	
}
