package com.GMT.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRoles;
	private String nombre;
	private String descripcion;
	
	
	public int getIdRoles() {
		return idRoles;
	}
	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
