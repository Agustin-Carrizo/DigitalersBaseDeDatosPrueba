package com.educacionit.DigitalersBaseDeDatosPrueba.implementaciones;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mariadb.jdbc.Connection;

import com.educacionit.DigitalersBaseDeDatosPrueba.DAO.DAO;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Clientes;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Cuentas;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Empleado;

public class ImplementacionCuentas implements DAO<Cuentas ,String> {
	
	private static final List<Clientes> Cuentas = null;
	protected PreparedStatement sentenciaPreparadaBusqueda;
	protected PreparedStatement sentenciaPreparadaInsertar;
	protected PreparedStatement sentenciaPreparadaEliminar;
	protected PreparedStatement sentenciaPreparadaActualizar;
	protected PreparedStatement sentenciaPreparadaListar;
	protected Connection conexion;

	public ImplementacionCuentas () {
		super();
	}

	public ImplementacionCuentas(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	public Cuentas buscarPorClavePrimaria(String id_cuenta) {
		String query = "Select id_cuenta, tipo, col_cliente from cuentas where id_cuenta = ?";
		try {
			if (sentenciaPreparadaBusqueda == null) {
				sentenciaPreparadaBusqueda = conexion.prepareStatement(query);
			}
			sentenciaPreparadaBusqueda.setString(1, id_cuenta);

			ResultSet resultado = sentenciaPreparadaBusqueda.executeQuery();

			if (resultado.next()) {
				String tipo = resultado.getString("tipo");
				Array col_cliente = (resultado.getArray("col_cliente"));

				Cuentas cuenta = new Cuentas(id_cuenta, tipo, col_cliente);
				return cuenta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertar(Cuentas e) {
		if (e == null) {
			return false;
		}
		String query = "insert into cuentas (id_cuenta,tipo,col_cliente) values (?,?,?)";
		try {
			if (sentenciaPreparadaInsertar == null) {
				sentenciaPreparadaInsertar = conexion.prepareStatement(query);
			}

			sentenciaPreparadaInsertar.setString(1, e.getId_cuentas());
			sentenciaPreparadaInsertar.setString(2, e.getTipoCuenta());
			sentenciaPreparadaInsertar.setArray(3, e.getCol_cliente());
			return sentenciaPreparadaInsertar.executeUpdate() == 1;
		} catch (SQLException e1) {
			e1.printStackTrace();

		}
		return false;
	}

	public boolean actualizar(Cuentas e) {
		if (e == null) {
			return false;
		}
		String query = "update cuentas set tipo = ?, col_cliente = ? where id_cuenta = ?";
		try {
			if (sentenciaPreparadaActualizar == null) {
				sentenciaPreparadaActualizar = conexion.prepareStatement(query);
			}

			sentenciaPreparadaActualizar.setString(1, e.getTipoCuenta());
			sentenciaPreparadaActualizar.setArray(2, e.getCol_cliente());
			sentenciaPreparadaActualizar.setString(3, e.getId_cuentas());

			return sentenciaPreparadaActualizar.executeUpdate() == 1;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean eliminar(Cuentas e) {
		if (e == null) {
			return false;
		}
		String query = "delete from cuentas where id_cuenta = ?";
		try {
			if (sentenciaPreparadaEliminar == null) {
				sentenciaPreparadaEliminar = conexion.prepareStatement(query);
			}
			sentenciaPreparadaEliminar.setString(1, e.getId_cuentas());

			return sentenciaPreparadaEliminar.executeUpdate() == 1;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public List<Clientes> listar() {
		List<Cuentas> cuentas = new ArrayList<>();
		String query = "Select id_cuenta, tipo , col_cliente from cuentas";

		try {
			if (sentenciaPreparadaListar == null) {
				sentenciaPreparadaListar = conexion.prepareStatement(query);
			}
			ResultSet resultado = sentenciaPreparadaListar.executeQuery();

			while (resultado.next()) {
				Cuentas cuenta = new Cuentas();
				cuenta.setId_cuentas(resultado.getString("id_cuenta"));
				cuenta.setTipoCuenta(resultado.getString("tipo"));
				cuenta.setCol_cliente(resultado.getArray("col_cliente"));
				cuentas.add(cuenta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cuentas;
	}


	public String buscarPorClavePrimaria1(Cuentas k) {
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

	public String buscarPorClavePrimaria(Cuentas k) {
		return null;
	}

	public List<Empleado> listar1() {
		return null;
	}

}



