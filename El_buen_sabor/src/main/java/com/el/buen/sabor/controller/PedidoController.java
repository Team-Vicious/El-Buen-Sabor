package com.el.buen.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.Pedido;
import com.el.buen.sabor.service.PedidoService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/pedido")
public class PedidoController extends ControllerImpl<Pedido, ServicesImpl<Pedido,Long>>{

	@Autowired
	PedidoService service;
	
	@GetMapping("/pedidos-clienteId/{id}")
	ResponseEntity<?> findPedidosByClienteId(@PathVariable Long id){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosByClienteId(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
		}
	}
}
