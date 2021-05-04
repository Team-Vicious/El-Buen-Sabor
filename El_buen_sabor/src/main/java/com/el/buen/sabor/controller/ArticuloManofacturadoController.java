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
	
	@PostMapping("/AMcrear-con-foto")
	public ResponseEntity<?> crear(@Valid ArticuloManofacturado articuloManufacturado, BindingResult result,
			@RequestParam MultipartFile foto) throws IOException {
		if(!foto.isEmpty()) {
			articuloManufacturado.setImagen(foto.getBytes());
		}
		return super.save(articuloManufacturado, result);
	}
	

	@PutMapping("/AM-editar-con-foto/{id}")
	public ResponseEntity<?> editar(@Valid ArticuloManofacturado articuloManufacturado,@PathVariable Long id,  BindingResult result, 
			@RequestParam MultipartFile archivo)  throws Exception {
		
		ArticuloManofacturado art;
		try {
			 art= this.service.findById(id);
			 			
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde.\"}");
						
		}
		
		ArticuloManofacturado articulo=art;
		
		articulo.setDenominacion(articuloManufacturado.getDenominacion());
		articulo.setPrecioVenta(articuloManufacturado.getPrecioVenta());
		articulo.setTiempoEstimadoCocina(articuloManufacturado.getTiempoEstimadoCocina());
	
		
	
	
	if(!archivo.isEmpty()) {
		articulo.setImagen(archivo.getBytes());
	}
	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(articulo));
	
	}

	
	
	
	

}
	
	

