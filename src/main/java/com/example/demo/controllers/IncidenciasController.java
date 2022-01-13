package com.example.demo.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Incidencia;
import com.example.demo.services.IncidenciaService;

@RestController
@RequestMapping("/incidencias")
public class IncidenciasController {
	
	@Autowired
	private IncidenciaService incidenciaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> registrarIncidencia(@RequestBody Incidencia incidencia) {
		Map<String, Object> response = new HashMap<>();
		response.put("incidencia_creada", incidenciaService.crearIncidencia(incidencia));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idIncidencia}")
	public ResponseEntity<?> obtenerIncidenciaPorId(@PathVariable Long idIncidencia) {
		Map<String, Object> response = new HashMap<>();
		response.put("incidencia", incidenciaService.obtenerIncidenciaPorId(idIncidencia));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/operador/{idOperador}")
	public ResponseEntity<?> obtenerIncidenciasPorOperador(@PathVariable Long idOperador) {
		Map<String, Object> response = new HashMap<>();
		response.put("incidencias", incidenciaService.obtenerIncidenciasPorOperador(idOperador));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fecha/{idOperador}")
	public ResponseEntity<?> obtenerIncidenciasPorFecha(@PathVariable Date fecha) {
		Map<String, Object> response = new HashMap<>();
		response.put("incidencia", incidenciaService.obtenerIncidenciaPorFecha(fecha));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/actualizar/{idIncidencia}")
	public ResponseEntity<?> obtenerIncidenciasPorFecha(@PathVariable Long idIncidencia, @RequestBody Incidencia incidencia) {
		Map<String, Object> response = new HashMap<>();
		response.put("incidencia_modificada", incidenciaService.actualizarIncidencia(idIncidencia, incidencia));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/activas")
	public ResponseEntity<?> obtenerIncidenciasActivas() {
		Map<String, Object> response = new HashMap<>();
		response.put("incidencias_Activas", incidenciaService.obtenerIncidenciasActivas());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
