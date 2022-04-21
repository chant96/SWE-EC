package com.GMT.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instructor {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;*/
	
	@Id
	@Column(name="dni",nullable = false,length = 8)
	private String dni;
	
	@Column(name="nombres",nullable = false,length = 45)
	private String nombres;
	
	@Column(name="apellidos",nullable = false,length = 45)
	private String apellidos;
	
	@Column(name="correoElectronico",nullable = false,length = 200)
	private String correoElectronico;
	
	@Column(name="telefono",nullable = false,length = 9)
	private String telefono;
	
	@Column(name="especialidad",nullable = false,length = 250)
	private String especialidad;
	
	@Column(name="direccion",nullable = false,length = 250)
	private String direccion;

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
