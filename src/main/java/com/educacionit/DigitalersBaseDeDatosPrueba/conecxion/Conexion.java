package com.educacionit.DigitalersBaseDeDatosPrueba.conecxion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Conexion {
	public static void main(String[] args) {
		String url ="jdbc:mariadb://localhost:3306/digitalerbasededatospractica";
    	String usuario = "root";
    	String clave = "";
    	String driver = "org.mariadb.jdbc.Driver";
       
      try {
		Class.forName(driver);
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("coneccion exitosa ");
			
			Statement sentencia = conexion.createStatement();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
    	
	}

	public Conexion() {
		super();
		
	}

}
