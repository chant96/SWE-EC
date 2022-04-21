package com.GMT.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Paginado <T>{
	
	private int primeraFila=0;
	private int ultimaFila=0;
	private int tamanioPagina=0;
	private int numeroPagina=0;
	private int totalfilas=0;
	private int totalPaginas=0;
	private List<T> filas;
	
	public Paginado() {
		this.primeraFila=0;
		this.ultimaFila=0;
		this.totalfilas=0;
		this.totalPaginas=0;
		this.filas=new ArrayList<T>();
	}


	public int getPrimeraFila() {
		return primeraFila;
	}

	public void setPrimeraFila(int primeraFila) {
		this.primeraFila = primeraFila;
	}

	public int getUltimaFila() {
		return ultimaFila;
	}

	public void setUltimaFila(int ultimaFila) {
		this.ultimaFila = ultimaFila;
	}

	public int getTamanioPagina() {
		return tamanioPagina;
	}

	public void setTamanioPagina(int tamanioPagina) {
		this.tamanioPagina = tamanioPagina;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getTotalfilas() {
		return totalfilas;
	}

	public void setTotalfilas(int totalfilas) {
		this.totalfilas = totalfilas;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public List<T> getFilas() {
		return filas;
	}

	public void setFilas(List<T> filas) {
		this.filas = filas;
	}
	

}
