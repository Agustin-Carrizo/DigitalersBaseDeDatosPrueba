package com.educacionit.DigitalersBaseDeDatosPrueba.Entidades;

import java.time.LocalDate;

public class Prestamos {
	
	Integer nroPrestamo;
	String tipoPrestamo;
	LocalDate fechaExpedicion;
	Integer cantCuotas;
	Boolean cancelado;
	
	
	public Prestamos() {
		super();
		
	}


	public Integer getNroPrestamo() {
		return nroPrestamo;
	}


	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}


	public String getTipoPrestamo() {
		return tipoPrestamo;
	}


	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}


	public LocalDate getFechaExpedicion() {
		return fechaExpedicion;
	}


	public void setFechaExpedicion(LocalDate fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}


	public Integer getCantCuotas() {
		return cantCuotas;
	}


	public void setCantCuotas(Integer cantCuotas) {
		this.cantCuotas = cantCuotas;
	}


	public Boolean getCancelado() {
		return cancelado;
	}


	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}


	public Prestamos(Integer nroPrestamo, String tipoPrestamo, LocalDate fechaExpedicion, Integer cantCuotas,
			Boolean cancelado) {
		super();
		this.nroPrestamo = nroPrestamo;
		this.tipoPrestamo = tipoPrestamo;
		this.fechaExpedicion = fechaExpedicion;
		this.cantCuotas = cantCuotas;
		this.cancelado = cancelado;
	}

	
	
}
