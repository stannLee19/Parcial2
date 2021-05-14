package com.unab.proyect.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.unab.proyect.Conexion.Conexion;
import com.unab.proyect.Entidades.Usuario;

import java.sql.CallableStatement;


public class clsLoguin {

	Conexion con = new Conexion();
	Connection coneccion = con.retornarConexion();
	public int id;



	public boolean Login(Usuario usu) {

		boolean resultado = false;
		ArrayList<Usuario> listaUsuariopass = new ArrayList<>();
		System.out.println(usu.getNombre() + usu.getPass());
		try {
			CallableStatement call = coneccion.prepareCall("Call SP_S_LOGIN(?,?)");
			call.setString("pUsu", usu.getNombre());
			call.setString("pPass", usu.getPass());
			ResultSet resul = call.executeQuery();
			while (resul.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(resul.getString("Nombre"));
				usuario.setPass(resul.getString("Contrasena"));
				usuario.setID(resul.getInt("ID"));
			   
				listaUsuariopass.add(usuario);
			}

			String usuBase = "";
			String passBase = "";

			for (var i : listaUsuariopass) {
				usuBase = i.getNombre();
				passBase = i.getPass();
			    id=i.getID();
			}
			
			if (usuBase != null && passBase != null) {
				if (usuBase.equals(usu.getNombre()) && passBase.equals(usu.pass)) {
					resultado = true;
				} else {
					resultado = false;

				}
			}
			coneccion.close();

		} catch (Exception e) {
			System.out.println("Error" + e);
		}

		return resultado;

	}

}
