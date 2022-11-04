package com.educacionit.DigitalersBaseDeDatosPrueba.Entidades;

import java.sql.Array;

public class Clientes {
	
		String id_Cliente;
		String apellido;
		String nombre;
		String calle;
		String ciudad;
		
		public Clientes() {
			super();
			
		}

		
		public String getId_Cliente() {
			return id_Cliente;
		}


		public void setId_Cliente(String string) {
			this.id_Cliente = string;
		}


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getCalle() {
			return calle;
		}


		public void setCalle(String calle) {
			this.calle = calle;
		}


		public String getCiudad() {
			return ciudad;
		}


		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}


		public Clientes(String apellido, String nombre, String calle, String ciudad) {
			super();
			this.apellido = apellido;
			this.nombre = nombre;
			this.calle = calle;
			this.ciudad = ciudad;
		}


		public Clientes(String id_Empleado, String apellido, String nombre, String calle, String ciudad) {
			super();
			this.id_Cliente = id_Empleado;
			this.apellido = apellido;
			this.nombre = nombre;
			this.calle = calle;
			this.ciudad = ciudad;
		}

		public Clientes(String id_cliente2, String nombre2, String calle2, String id_empleado, boolean prestamo,
				Array col_cuenta) {
		}

		public String toString() {
			return "Clientes [id_Empleado=" + id_Cliente + ", apellido=" + apellido + ", nombre=" + nombre + ", calle="
					+ calle + ", ciudad=" + ciudad + "]";
		}

		public String getId_clientes() {
			return null;
		}
		public String getId_empleado() {
			return null;
		}
		public boolean isPrestamo() {
			return false;
		}
		public Array getCol_cuenta() {
			return null;
		}
		public void setId_empleado(String string) {
		}
		public void setPrestamo(boolean boolean1) {
		}
		public void setCol_cuenta(Array array) {
		}


		
		

		
}	


