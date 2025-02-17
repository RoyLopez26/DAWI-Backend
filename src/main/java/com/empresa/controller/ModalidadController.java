package com.empresa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/modalidad")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ModalidadController {

	@Autowired
	private ModalidadService modalidadService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Modalidad>> listaModalidad(){
		List<Modalidad> lista = modalidadService.listaModalidad();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<?> insertaModalidad( @RequestBody Modalidad obj){
		Map<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<>();
		salida.put("errors", lstMensajes);

		Modalidad objSalida = modalidadService.insertaActualizaModalidad(obj);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		}else {
			lstMensajes.add("Se registró la modalidad de ID ==> " + objSalida.getIdModalidad());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
}




