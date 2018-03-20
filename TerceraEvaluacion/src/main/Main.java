package main;

import dao.AccesosTienda;

public class Main {

	public static void main(String[] args) {
		AccesosTienda conexion = new AccesosTienda("root", "", "localhost", "test");
		conexion.getConnection();
	}
	
}
