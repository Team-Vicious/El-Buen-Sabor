package com.el.buen.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.DetallePedido;
import com.el.buen.sabor.service.DetallePedidoService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/detallePedido")
public class DetallePedidoController extends ControllerImpl<DetallePedido, ServicesImpl<DetallePedido,Long>>{

	@Autowired
	DetallePedidoService service;
	
	@PutMapping("/detalle-pedido-reducirstock")
	public ResponseEntity<?> reducirStock(@RequestBody DetallePedido[] detallePedido) {

		try {
			service.reducirStock(detallePedido);
			return ResponseEntity.status(HttpStatus.OK).body("stock reducido");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}" + e.getMessage());
		}
	}
}
