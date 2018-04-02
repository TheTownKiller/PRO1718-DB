package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AccesosTienda {

	private String usuario;
	private String clave;
	private String host = "";
	private String bd = "";
	private final String url = "jdbc:mysql://" + host + "/" + bd;
	
	public static ArrayList<Boolean>ListaBoleanos = new ArrayList<Boolean>();
	public static ArrayList<Integer>ListaInteger = new ArrayList<Integer>();
	public static ArrayList<Double>ListaDouble = new ArrayList<Double>();
	public static ArrayList<Character>ListaCharacter = new ArrayList<Character>();
	public static ArrayList<String>ListaString = new ArrayList<String>();

	public AccesosTienda(String usuario, String clave, String host, String bd) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.host = host;
		this.bd = bd;
	}

	public ArrayList<HashMap<String, Object>> getAllRecords(String tabla) {
		ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
		Connection conexion = this.getConnection();
		String sql = "SELECT * FROM " + tabla;
		try {
			Statement stm = conexion.createStatement();
			stm.execute("use " + bd);
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData metaData= rs.getMetaData();
			while(rs.next()) {
				HashMap<String, Object>mapa = new HashMap<String, Object>();	
				
				for(int i = 1; i<=metaData.getColumnCount(); i++) {
				mapa.put(metaData.getColumnName(i), rs.getObject(i));
				}
				registros.add(mapa);
	
			}
			System.out.println(registros);
			return registros;
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION");
		}
		return null;
		

	}

	public void isAnInstanceOf(ArrayList<HashMap<String, Object>> lista) {
		
		for (int i = 0; i < lista.size(); i++) {
			for (String key : lista.get(i).keySet()) {
				Object objeto = lista.get(i).get(key);
				if (objeto instanceof Boolean) {
					ListaBoleanos.add((Boolean) objeto);
				} else if (objeto instanceof Integer) {
					ListaInteger.add((Integer) objeto);
				} else if (objeto instanceof Double) {
					ListaDouble.add((Double) objeto);
				} else if (objeto instanceof Character) {
					ListaCharacter.add((Character) objeto);
				} else if (objeto instanceof String) {
					ListaString.add((String) objeto);
				}
			}
		}	
	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("Error de Instanciación");
			
		} catch (IllegalAccessException e) {
			System.out.println("Ilegal Access");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Connection Successful");
			return connection;
		} catch (SQLException e) {
			System.out.println("ErrorSQL");
		}

		System.out.println("No has conectado con la base de datos");
		return null;
	}

}
