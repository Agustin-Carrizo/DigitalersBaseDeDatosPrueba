package com.educacionit.DigitalersBaseDeDatosPrueba.Entidades;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Empleado {
	
	Integer id_empleado;
	String nombre;
	String telefono;
	Integer id_Jefe;
	LocalDate fechaIncorp;
	
	public Empleado() {
		super();
		
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getId_Jefe() {
		return id_Jefe;
	}

	public void setId_Jefe(Integer id_Jefe) {
		this.id_Jefe = id_Jefe;
	}

	public LocalDate getFechaIncorp() {
		return fechaIncorp;
	}

	public void setFechaIncorp(LocalDate fechaIncorp) {
		this.fechaIncorp = fechaIncorp;
	}

	public Empleado(Integer id_empleado, String nombre, String telefono, Integer id_Jefe, LocalDate fechaIncorp) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.telefono = telefono;
		this.id_Jefe = id_Jefe;
		this.fechaIncorp = fechaIncorp;
	}

	public Empleado(String k, String nombre2, String telefono2, LocalDateTime fecha, String id_empleado_sup,
			Array col_nombre_sub) {
	}

	public Array getCol_nombre_sub() {
		return null;
	}

	public void setId_empleado(String string) {
		
	}

	public void setFecha_incorporacion(LocalDateTime parse) {
		
	}

	public void setId_empleado_sup(String string) {
		
	}

	public void setCol_nombre_sub(Array array) {
		
	}

}
