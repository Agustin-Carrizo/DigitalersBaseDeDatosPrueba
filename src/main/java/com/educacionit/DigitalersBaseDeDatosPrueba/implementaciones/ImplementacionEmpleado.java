package com.educacionit.DigitalersBaseDeDatosPrueba.implementaciones;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mariadb.jdbc.Connection;

import com.educacionit.DigitalersBaseDeDatosPrueba.DAO.DAO;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Clientes;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Cuentas;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Empleado;

public class ImplementacionEmpleado implements DAO<Empleado, String>{


	PreparedStatement sentenciaPreparadaBusqueda;
	PreparedStatement sentenciaPreparadaInsertar;
	PreparedStatement sentenciaPreparadaEliminar;
	PreparedStatement sentenciaPreparadaActualizar;
	PreparedStatement sentenciaPreparadaListar;
	Connection conexion;
	
	
	public ImplementacionEmpleado() {
		super();
	}

	public ImplementacionEmpleado(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	public Empleado buscarPorClavePrimaria(String k) {
		String query = "Select id_empleado, nombre, telefono, fecha_incorporacion, id_empleado_sup, col_nombre_sub from empleados where id_empleado = ?";
		try {
			if (sentenciaPreparadaBusqueda == null) {
				sentenciaPreparadaBusqueda = conexion.prepareStatement(query);
			}
			sentenciaPreparadaBusqueda.setString(1, k);

			ResultSet resultado = sentenciaPreparadaBusqueda.executeQuery();

			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String telefono = resultado.getString("telefono");
				LocalDateTime fecha = LocalDateTime.parse(resultado.getString("fecha_incorporacion"));
				String id_empleado_sup = resultado.getString("id_empleado_sup");
				Array col_nombre_sub = (resultado.getArray("col_nombre_sub"));

				Empleado empleado = new Empleado(k, nombre, telefono, fecha, id_empleado_sup, col_nombre_sub);

				return empleado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertar(Empleado e) {
		if (e == null) {
			return false;
		}
		String query = "insert into empleados (id_empleado,nombre,telefono,fecha_incorporacion,id_empleado_sup, col_nombre_sub) values (?,?,?,NOW(),?,?)";
		try {
			if (sentenciaPreparadaInsertar == null) {
				sentenciaPreparadaInsertar = conexion.prepareStatement(query);
			}

			sentenciaPreparadaInsertar.setLong(1, e.getId_empleado());
			sentenciaPreparadaInsertar.setString(2, e.getNombre());
			sentenciaPreparadaInsertar.setString(3, e.getTelefono());
			sentenciaPreparadaInsertar.setLong(4, e.getId_empleado());
			sentenciaPreparadaInsertar.setArray(5, e.getCol_nombre_sub());
			return sentenciaPreparadaInsertar.executeUpdate() == 1;
		} catch (SQLException e1) {
			e1.printStackTrace();

		}
		return false;
	}

	public boolean actualizar(Empleado e) {
		if (e == null) {
			return false;
		}
		String query = "update empleados set telefono = ?, col_nombre_sub = ? where id_empleado = ?";
		try {
			if (sentenciaPreparadaActualizar == null) {
				sentenciaPreparadaActualizar = conexion.prepareStatement(query);
			}

			sentenciaPreparadaActualizar.setString(1, e.getTelefono());
			sentenciaPreparadaActualizar.setArray(2, e.getCol_nombre_sub());
			sentenciaPreparadaActualizar.setLong(3, e.getId_empleado());

			return sentenciaPreparadaActualizar.executeUpdate() == 1;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean eliminar(Empleado e) {
		if (e == null) {
			return false;
		}
		String query = "delete from empleados where id_empleado = ?";
		try {
			if (sentenciaPreparadaEliminar == null) {
				sentenciaPreparadaEliminar = conexion.prepareStatement(query);
			}
			sentenciaPreparadaEliminar.setLong(1, e.getId_empleado());

			return sentenciaPreparadaEliminar.executeUpdate() == 1;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public List<Empleado> listar1() {
		List<Empleado> empleados = new ArrayList<>();
		String query = "Select id_empleado, nombre, telefono, fecha_incorporacion, id_empleado_sup, col_nombre_sub from empleados";

		try {
			if (sentenciaPreparadaListar == null) {
				sentenciaPreparadaListar = conexion.prepareStatement(query);
			}
			ResultSet resultado = sentenciaPreparadaListar.executeQuery();

			while (resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setId_empleado(resultado.getString("id_empleado"));
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setTelefono(resultado.getString("telefono"));
				empleado.setFecha_incorporacion(LocalDateTime.parse(resultado.getString("fecha_incorporacion")));
				empleado.setId_empleado_sup(resultado.getString("id_empleado_sup"));
				empleado.setCol_nombre_sub(resultado.getArray("col_nombre_sub"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public String buscarPorClavePrimaria(Empleado k) {
		return null;
	}

	public boolean insertar(String e) {
		return false;
	}

	public boolean actualizar(String e) {
		return false;
	}

	public boolean eliminar(String e) {
		return false;
	}

	public String buscarPorClavePrimaria1(Cuentas k) {
		return null;
	}

	public List<Clientes> listar() {
		return null;
	}
	
}
