package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Incidencia;
import com.example.demo.repositories.IncidenciaRepository;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {
	
	@Autowired
	private IncidenciaRepository incidenciaRepository;

	@Override
	public Incidencia obtenerIncidenciaPorId(Long idIncidencia) {
		return incidenciaRepository.findById(idIncidencia).get();
	}

	@Override
	public Incidencia crearIncidencia(Incidencia incidencia) {
		return incidenciaRepository.save(incidencia);
	}

	@Override
	public List<Incidencia> obtenerIncidenciasPorOperador(Long idOperador) {
		return incidenciaRepository.obtenerIncidenciasPorOperador(idOperador);
	}

	@Override
	public List<Incidencia> obtenerIncidenciaPorFecha(Date fecha) {
		return incidenciaRepository.obtenerIncidenciasPorFecha(fecha);
	}

	@Override
	public Incidencia actualizarIncidencia(Long idIncidencia, Incidencia incidencia) {
		Incidencia incidenciaModificar = incidenciaRepository.getById(idIncidencia);
		incidenciaModificar.setFecha(incidencia.getFecha());
		incidenciaModificar.setDescripcion(incidencia.getDescripcion());
		incidenciaModificar.setStatus(incidencia.isStatus());
		incidenciaModificar.setIdOperador(incidencia.getIdOperador());
		incidenciaModificar.setIdEquipo(incidencia.getIdEquipo());
		return incidenciaRepository.save(incidenciaModificar);
	}

	@Override
	public List<Incidencia> obtenerIncidenciasActivas() {
		return incidenciaRepository.obtenerIncidenciasActivas();
	}
	
	

}
