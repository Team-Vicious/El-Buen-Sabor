package com.el.buen.sabor.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.el.buen.sabor.entity.ArticuloManofacturado;
import com.el.buen.sabor.service.ArticuloManofacturadoService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articuloManoFacturado")
public class ArticuloManofacturadoController extends ControllerImpl<ArticuloManofacturado, ServicesImpl<ArticuloManofacturado,Long>>{

	@Autowired
	ArticuloManofacturadoService service;
	/*
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@Valid ArticuloManofacturado articuloManufacturado, BindingResult result,
			@RequestParam MultipartFile foto) throws IOException {
		if(!foto.isEmpty()) {
			articuloManufacturado.setImagen(foto.getBytes());
		}
		return super.save(articuloManufacturado, result);
	}
	*/

	/*@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@Valid ArticuloManofacturado articuloManufacturado,@PathVariable Long id,  BindingResult result, 
			@RequestParam MultipartFile foto)  throws IOException {
		
		if(result.hasErrors()) {
			return this.validar(result);
			
		}
		
		ArticuloManofacturado articulo = articuloManufacturado.
		
	Optional<> opcional= service.findArticuloManofacturadoById(id);
	
	if(opcional.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	
	alumnoddbb.setNombre(alumno.getNombre()); 
	alumnoddbb.setApellido(alumno.getApellido());
	alumnoddbb.setEmail(alumno.getEmail());
	
	if(!foto.isEmpty()) {
		alumnoddbb.setFoto(foto.getBytes());
	}
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoddbb));
	
	}
		
		return super.update(id, articuloManufacturado, result);
	}*/

	
	
	
	

}
	
	

