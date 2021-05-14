package com.unab.proyect.Conexion;

import java.sql.*;


public class Conexion {
	private Connection conexion;

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conexion = DriverManager.getConnection("jdbc:mysql://localhost/parcial3", "root", "root");
	            System.out.println("Conexion exitosa");

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION A LA BD " + e);
		}
	}

	public Connection retornarConexion() {
		return conexion;
	}

}

