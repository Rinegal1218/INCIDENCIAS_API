package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "incidencias")
public class Incidencia implements Serializable {
	
	@Id
	@Column(name = "id_incidencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIncidencia;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne
	@Column(name = "id_operador")
	private Operador idOperador;
	
	@ManyToOne
	@Column(name = "id_equipo")
	private Equipo idEquipo;

	public Long getIdIncidencia() {
		return idIncidencia;
	}

	public void setIdIncidencia(Long idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Operador getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(Operador idOperador) {
		this.idOperador = idOperador;
	}

	public Equipo getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Equipo idEquipo) {
		this.idEquipo = idEquipo;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
