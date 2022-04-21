package com.GMT.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Maquina {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="tipoDeMaquina",nullable = false,length = 20)
	private String tipoDeMaquina;
	
	@Column(name="descripcion",nullable = false,length = 300)
	private String descripcion;
	
	@Column(name="montoMaquina",nullable = false)
	private float montoMaquina;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDeMaquina() {
		return tipoDeMaquina;
	}

	public void setTipoDeMaquina(String tipoDeMaquina) {
		this.tipoDeMaquina = tipoDeMaquina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getMontoMaquina() {
		return montoMaquina;
	}

	public void setMontoMaquina(float montoMaquina) {
		this.montoMaquina = montoMaquina;
	}
	
	
	
	
}
