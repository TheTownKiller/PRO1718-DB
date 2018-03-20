package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesosTienda {
	
	private String usuario;
	private String clave;
	private String host = "";
	private String bd = "";
	private final String url = "jdbc:mysql://" + host + "/" + bd;
	
	public AccesosTienda(String usuario, String clave, String host, String bd) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.host = host;
		this.bd = bd;
	}

	public Connection getConnection() {
		try {
			
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		} catch (InstantiationException e) {
			System.out.println("Error de Instanciación");
		} catch (IllegalAccessException e) {
			System.out.println("Ilegal Access");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try {
			Connection connection = DriverManager.getConnection (url, usuario, clave);
			System.out.println("Connection Successful");
			return connection;
		} catch (SQLException e) {
			System.out.println("ErrorSQL");
		}
		
		System.out.println("No has conectado con la base de datos");
		return null;
	}

}
