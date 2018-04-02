package main;

import dao.AccesosTienda;

public class Main {

	public static void main(String[] args) {
		AccesosTienda conexion = new AccesosTienda("root", "", "localhost", "test");
		conexion.isAnInstanceOf(conexion.getAllRecords("producto"));
		System.out.println();
		
		System.out.println("Boleanos   "  + AccesosTienda.ListaBoleanos);
		System.out.println("Integer    "  + AccesosTienda.ListaInteger);
		System.out.println("Double     "  + AccesosTienda.ListaDouble);
		System.out.println("Char       "  + AccesosTienda.ListaCharacter);
		System.out.println("String     "  + AccesosTienda.ListaString);
	}
	
}
