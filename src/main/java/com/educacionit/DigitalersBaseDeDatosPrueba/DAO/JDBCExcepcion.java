package com.educacionit.DigitalersBaseDeDatosPrueba.DAO;

public class JDBCExcepcion extends Exception {

	
	private static final long serialVersionUID = 1L;

	public JDBCExcepcion() {
		super();
		
	}

	public JDBCExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public JDBCExcepcion(String message, Throwable cause) {
		super(message, cause);
		
	}

	public JDBCExcepcion(Throwable cause) {
		super(cause);
		
	}

	public JDBCExcepcion(String string) {
		
	}

}
