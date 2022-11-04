package com.educacionit.DigitalersBaseDeDatosPrueba.DAO;

import java.util.List;

import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Clientes;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Cuentas;
import com.educacionit.DigitalersBaseDeDatosPrueba.Entidades.Empleado;

public interface DAO<K, E> {
	
public E buscarPorClavePrimaria(K k);
	
	public boolean insertar(E e);
	
	public boolean actualizar(E e);
	
	public boolean eliminar(E e);
	
	public List<Empleado> listar1();
	
	public List<Clientes> listar();

	String buscarPorClavePrimaria1(Cuentas k);
	

}
