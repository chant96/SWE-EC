package com.GMT.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;
	
	@OneToOne
	@JoinColumn(name = "certificado_id")
	private Certificado certificado;
	
	@OneToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@Column(name="nombre",nullable = false )
	private String nombre;
	
	/*@Column(name="nivel",nullable = false)
	private short nivel;
	
	@Column(name = "horas",nullable = false)
	private short horas;*/
	
	@Column(name = "descripcion",nullable = false)
	private String descripcion;
	
	@Column(name = "tipoDeCurso",nullable = false,length = 45)
	private String tipoDeCurso;
	
	/*@Column(name = "montoCurso",nullable = false)
	private float montoCurso;*/

	public Curso() {
		
		this.certificado=new Certificado();
		this.instructor=new Instructor();
		this.horario=new Horario();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public short getNivel() {
		return nivel;
	}

	public void setNivel(short nivel) {
		this.nivel = nivel;
	}

	public short getHoras() {
		return horas;
	}

	public void setHoras(short horas) {
		this.horas = horas;
	}*/

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoDeCurso() {
		return tipoDeCurso;
	}

	public void setTipoDeCurso(String tipoDeCurso) {
		this.tipoDeCurso = tipoDeCurso;
	}

	/*public float getMontoCurso() {
		return montoCurso;
	}

	public void setMontoCurso(float montoCurso) {
		this.montoCurso = montoCurso;
	}*/

	
	
}
