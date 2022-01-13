package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Incidencia;

public interface IncidenciaService {
	
	public Incidencia obtenerIncidenciaPorId(Long idIncidencia);
	
	public Incidencia crearIncidencia(Incidencia incidencia);
	
	public List<Incidencia> obtenerIncidenciasPorOperador(Long idOperador);
	
	public List<Incidencia> obtenerIncidenciaPorFecha(Date fecha);
	
	public Incidencia actualizarIncidencia(Long idIncidencia, Incidencia incidencia);
	
	public List<Incidencia> obtenerIncidenciasActivas();

}
