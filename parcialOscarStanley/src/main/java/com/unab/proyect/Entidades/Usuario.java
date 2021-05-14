package com.unab.proyect.Entidades;

import lombok.Data;

@Data
public class Usuario {

	public  int ID;
	public String Nombre;
	public String pass; 
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
