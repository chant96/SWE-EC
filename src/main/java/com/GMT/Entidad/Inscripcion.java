package com.GMT.Entidad;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class Inscripcion {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_dni")
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	/*@OneToOne
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;*/
	
	
	@JoinTable(
			//Name: Nombre de la tabla que ser� creada f�sicamente en la base de datos
			//joinColumns: Corresponde al nombre para el ID de la Entidad Inscripcion
			//inverseJoinColumns: Corresponde al nombre para el ID de la Entidad Maquina
			name = "MaquinasInscripcion",
			joinColumns = @JoinColumn(name="inscripcion_id",nullable = false),
			inverseJoinColumns = @JoinColumn(name="maquina_id",nullable = false)
			)
	@ManyToMany()
	private List<Maquina> maquinas;
	
	
	/*@OneToMany(mappedBy = "inscripcion")
	private List<Pago> pago;*/
	
	/*@Column(name="tipoDeInscripcion", nullable = false, length = 45)
	private String tipoDeInscripcion;*/
	
	/*@Column(name="fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fecha;*/
	
	@Column(name="fechaActual", nullable = false, length = 15)
	private String fechaActual;
	
	@Column(name="MontoTotal", nullable = false)
	private float MontoTotal;
	
	@Column(name="MontoRestante", nullable = false)
	private float MontoRestante;
	
	@Column(name="promocion", nullable = false, length = 15)
	private String promocion;
	
	/*@Column(name="turno", nullable = false, length = 25)
	private String turno;*/
	
	@ElementCollection
	 @CollectionTable(
	        name="turnos",
	        joinColumns=@JoinColumn(name="idInscripcion")
	  )
	  @Column(name="turno")
	private List<String> turno;
	
	@Transient
	private int anio;
	
	public Inscripcion() {
		
		this.curso=new Curso();
		this.maquinas=new ArrayList<Maquina>();
		this.estudiante=new Estudiante();
		this.MontoTotal=50;
		this.MontoRestante=50;
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		this.anio = calendar.get(Calendar.YEAR);
		
	}

	
	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public List<String> getTurno() {
		return turno;
	}

	public void setTurno(List<String> turno) {
		this.turno = turno;
	}

	public List<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public String getFechaActual() {
		return fechaActual;
	}


	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}


	public float getMontoTotal() {
		return MontoTotal;
	}


	public void setMontoTotal(float montoTotal) {
		MontoTotal = montoTotal;
	}


	public float getMontoRestante() {
		return MontoRestante;
	}


	public void setMontoRestante(float montoRestante) {
		MontoRestante = montoRestante;
	}



	public String getPromocion() {
		return promocion;
	}



	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}



	/*public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}

	/*public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}*/


	
	
	
}
