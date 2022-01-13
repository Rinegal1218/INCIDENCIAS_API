package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
	
	@Query(value = "SELECT * FROM incidencias WHERE id_operador = ?1", nativeQuery = true)
	public List<Incidencia> obtenerIncidenciasPorOperador(Long idOperador);
	
	@Query(value = "SELECT * FROM incidencias WHERE fecha = ?1", nativeQuery = true)
	public List<Incidencia> obtenerIncidenciasPorFecha(Date fecha);
	
	@Query(value = "SELECT * FROM incidencias WHERE status = 1", nativeQuery = true)
	public List<Incidencia> obtenerIncidenciasActivas();
}
