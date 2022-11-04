package com.educacionit.DigitalersBaseDeDatosPrueba.Entidades;

import java.sql.Array;
import java.time.LocalDate;

public class Cuentas {
	
	Integer nroCuenta;
	String tipoCuenta;
	LocalDate fechaCreacion;
	Boolean activa;
	
	
	public Cuentas() {
		super();
		
	}


	public Integer getNroCuenta() {
		return nroCuenta;
	}


	public void setNroCuenta(Integer nroCuenta) {
		this.nroCuenta = nroCuenta;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Boolean getActiva() {
		return activa;
	}


	public void setActiva(Boolean activa) {
		this.activa = activa;
	}


	public Cuentas(Integer nroCuenta, String tipoCuenta, LocalDate fechaCreacion, Boolean activa) {
		super();
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.fechaCreacion = fechaCreacion;
		this.activa = activa;
	}


	public Cuentas(String id_cuenta, String tipo, Array cliente) {
		// TODO Auto-generated constructor stub
	}


	public String getId_cuentas() {
		// TODO Auto-generated method stub
		return null;
	}


	public Array getCol_cliente() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setId_cuentas(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setCol_cliente(Array array) {
		// TODO Auto-generated method stub
		
	}

	
	
}
