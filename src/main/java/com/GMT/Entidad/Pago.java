package com.GMT.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pago {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "inscripcion_id")
	private Inscripcion inscripcion;
	
	@Column(name="numeroDePago", nullable = false, length = 15)
	private String numeroDePago;
	
	@Column(name="tipoDePago", nullable = false, length = 30)
	private String tipoDePago;
	
	
	
	public Pago() {
		this.inscripcion=new Inscripcion();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getNumeroDePago() {
		return numeroDePago;
	}

	public void setNumeroDePago(String numeroDePago) {
		this.numeroDePago = numeroDePago;
	}

	public String getTipoDePago() {
		return tipoDePago;
	}

	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}
	
	
}
