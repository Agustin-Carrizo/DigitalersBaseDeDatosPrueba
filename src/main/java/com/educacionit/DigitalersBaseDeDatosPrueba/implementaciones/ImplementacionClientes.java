package com.educacionit.DigitalersBaseDeDatosPrueba.implementaciones;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.DigitalersBaseDeDatosPrueba.DAO.DAO;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Clientes;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Cuentas;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Empleado;

public class ImplementacionClientes implements DAO<Clientes, String> {
	
	
	 PreparedStatement sentenciaPreparadaBusqueda;
	 PreparedStatement sentenciaPreparadaInsertar;
	 PreparedStatement sentenciaPreparadaEliminar;
	 PreparedStatement sentenciaPreparadaActualizar;
	 PreparedStatement sentenciaPreparadaListar;
	 Connection conexion;

	public ImplementacionClientes() {
		super();
	}

	public void ClienteImplementacion(Connection conexion) {
		this.conexion = conexion;
	}

	public Clientes buscarPorClavePrimaria(String id_cliente) {

		String query = "Select id_cliente, nombre, calle, id_empleado, prestamo, col_cuenta from clientes where id_cliente = ?";
		try {
			if (sentenciaPreparadaBusqueda == null) {
				sentenciaPreparadaBusqueda = conexion.prepareStatement(query);
			}
			sentenciaPreparadaBusqueda.setString(1, id_cliente);

			ResultSet resultado = sentenciaPreparadaBusqueda.executeQuery();

			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String calle = resultado.getString("calle");
				String id_empleado = resultado.getString("id_empleado");
				boolean prestamo = resultado.getBoolean("prestamo");
				Array col_cuenta = (resultado.getArray("col_cuenta"));

				Clientes cliente = new Clientes(id_cliente, nombre, calle, id_empleado, prestamo, col_cuenta);
				return cliente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertar(Clientes e) {
		if (e == null) {
			return false;
		}
		String query = "insert into clientes (id_cliente,nombre,calle,id_empleado,prestamo,col_cuenta) values (?,?,?,?,?,?)";
		try {
			if (sentenciaPreparadaInsertar == null) {
				sentenciaPreparadaInsertar = conexion.prepareStatement(query);
			}

			sentenciaPreparadaInsertar.setString(1, e.getId_clientes());
			sentenciaPreparadaInsertar.setString(2, e.getNombre());
			sentenciaPreparadaInsertar.setString(3, e.getCalle());
			sentenciaPreparadaInsertar.setString(4, e.getId_empleado());
			sentenciaPreparadaInsertar.setBoolean(5, e.isPrestamo());
			sentenciaPreparadaInsertar.setArray(6, e.getCol_cuenta());
			return sentenciaPreparadaInsertar.executeUpdate() == 1;
		} catch (SQLException e1) {
			e1.printStackTrace();

		}
		return false;
	}

	public boolean actualizar(Clientes e) {
		if (e == null) {
			return false;
		}
		String query = "update clientes set calle = ?, prestamo = ? where id_cliente = ?";
		try {
			if (sentenciaPreparadaActualizar == null) {
				sentenciaPreparadaActualizar = conexion.prepareStatement(query);
			}

			sentenciaPreparadaActualizar.setString(1, e.getCalle());
			sentenciaPreparadaActualizar.setBoolean(2, e.isPrestamo());
			sentenciaPreparadaActualizar.setString(3, e.getId_clientes());

			return sentenciaPreparadaActualizar.executeUpdate() == 1;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean eliminar(Clientes e) {
		if (e == null) {
			return false;
		}
		String query = "delete from clientes where id_cliente = ?";
		try {
			if (sentenciaPreparadaEliminar == null) {
				sentenciaPreparadaEliminar = conexion.prepareStatement(query);
			}
			sentenciaPreparadaEliminar.setString(1, e.getId_clientes());

			return sentenciaPreparadaEliminar.executeUpdate() == 1;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public List<Clientes> listar() {
		List<Clientes> clientes = new ArrayList<>();
		String query = "Select id_cliente, nombre, calle, id_empleado, prestamo, col_cuenta from clientes";

		try {
			if (sentenciaPreparadaListar == null) {
				sentenciaPreparadaListar = conexion.prepareStatement(query);
			}
			ResultSet resultado = sentenciaPreparadaListar.executeQuery();

			while (resultado.next()) {
				Clientes cliente = new Clientes();
				cliente.setId_Cliente(resultado.getString("id_cliente"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCalle(resultado.getString("calle"));
				cliente.setId_empleado(resultado.getString("id_empleado"));
				cliente.setPrestamo(resultado.getBoolean("prestamo"));
				cliente.setCol_cuenta(resultado.getArray("col_cuenta"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}


	public boolean insertar(String e) {
		return false;
	}


	public String buscarPorClavePrimaria(Clientes k) {
		return null;
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

	public List<Empleado> listar1() {
		return null;
	}

}
