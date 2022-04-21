package com.GMT.Entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

@Entity
public class Estudiante {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column( name = "dni", nullable = false, length = 8) 
	private String dni;*/
	 
	@Id
	@Column( name = "dni", nullable = false, length = 8)  
	private String dni;
	
	@Column( name = "nombres", nullable = false, length = 80) 
	private String nombres;
	
	@Column( name = "apellidos", nullable = false, length = 80)
	private String apellidos;
	
	@Column( name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@Email
	@Column( name = "correoElectronico", nullable = false, length = 120 , unique = true)
	private String correoElectronico;
	
	@Column( name = "direccion", nullable = false, length = 140)
	private String direccion;
	
	@Column( name = "fechaNacimiento", nullable = false, length =50)
	private String fechaNacimiento;
	
	@Column(name="departamento", nullable = false, length = 45)
	private String departamento;
	
	@Column(name="provincia", nullable = false, length = 45)
	private String provincia;
	
	@Column(name="distrito", nullable = false, length = 45)
	private String distrito;
	
	@OneToMany(mappedBy = "estudiante")
	private List<Inscripcion> inscripcion;

	
	public Estudiante() {
		
		this.inscripcion=new ArrayList<Inscripcion>();
		
	}
	
	
	
	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

/*	public List<Inscripcion> getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(List<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}*/

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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
 
	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
}
