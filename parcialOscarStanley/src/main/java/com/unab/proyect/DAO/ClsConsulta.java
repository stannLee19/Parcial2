package com.unab.proyect.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.unab.proyect.Conexion.Conexion;
import com.unab.proyect.Entidades.Consulta;
import com.unab.proyect.Entidades.Usuario;

public class ClsConsulta {

	Conexion con = new Conexion();
    Connection coneccion = con.retornarConexion();
public ArrayList<Consulta> MostrarConsulta() {
	ArrayList<Consulta> lista = new ArrayList<>();
	try {
		CallableStatement st = coneccion.prepareCall("select *from consulta ");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Consulta U = new Consulta();
			U.setID(rs.getInt("Id"));
			U.setNombre(rs.getString("Nombre"));
			U.setApellido(rs.getString("Apellido"));
			
			lista.add(U);
			
		}

	} catch (Exception e) {
		System.out.println(e);
	}
	return lista;
}
public void Eliminar(Consulta usu) {
	try {
		CallableStatement consulta = coneccion.prepareCall("call SP_D_Consulta (?) ");
		consulta.setInt("pID", usu.getID());
		consulta.execute();
		System.out.println("exito");
		coneccion.close();
	} catch (Exception e) {
		System.out.println("error" );
		
	}
	
	
	
}

	
}
