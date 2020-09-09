package com.system.green.house.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptUserMaintenanceCreadoPor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String creadoPor;
	
	private String mantenimiento;
	
	private BigInteger stdmantenimientos;
	
	public RptUserMaintenanceCreadoPor(String creadoPor, String mantenimiento, BigInteger stdmantenimientos) {
		super();
		this.creadoPor=creadoPor;
		this.mantenimiento = mantenimiento;
		this.stdmantenimientos = stdmantenimientos;
		
	}
	
	public RptUserMaintenanceCreadoPor() {
		super();
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public BigInteger getStdmantenimientos() {
		return stdmantenimientos;
	}

	public void setStdmantenimientos(BigInteger stdmantenimientos) {
		this.stdmantenimientos = stdmantenimientos;
	}
	
	
}
