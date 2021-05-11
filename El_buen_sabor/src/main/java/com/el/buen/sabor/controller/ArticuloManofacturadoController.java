package com.el.buen.sabor.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@Valid ArticuloManofacturado articuloManufacturado, BindingResult result,
			@RequestParam MultipartFile foto) throws IOException {
		if(!foto.isEmpty()) {
			articuloManufacturado.setImagen(foto.getBytes());
		}
		return super.save(articuloManufacturado, result);
	}
	


	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@Valid ArticuloManofacturado articuloManufacturado,@PathVariable Long id,  BindingResult result, 
			@RequestParam MultipartFile foto)  throws Exception {
		
		ArticuloManofacturado articuloOp;
		try {
			 articuloOp= this.service.findById(id);

			 			
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde.\"}");
						
		}
		

		ArticuloManofacturado articuloDB=articuloOp;
		
		articuloDB.setDenominacion(articuloManufacturado.getDenominacion());
		articuloDB.setTiempoEstimadoCocina(articuloManufacturado.getTiempoEstimadoCocina());
		articuloDB.setPrecioVenta(articuloManufacturado.getPrecioVenta());
	
	
	if(!foto.isEmpty()) {
		articuloDB.setImagen(foto.getBytes());
	}

	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(articuloDB));
	
	}


}
	
	

