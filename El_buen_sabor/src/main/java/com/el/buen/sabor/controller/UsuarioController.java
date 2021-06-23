package com.el.buen.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.Usuario;
import com.el.buen.sabor.service.UsuarioService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/usuario")
public class UsuarioController extends ControllerImpl<Usuario, ServicesImpl<Usuario,Long>>{

	@Autowired
	UsuarioService service;
	
	@GetMapping("/usuario-clienteId/{id}")
	public ResponseEntity<?> findUsuarioByClienteId(@PathVariable Long id) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findUsuarioByClienteId(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
		}
	}
	
	@GetMapping("/login/{user}/{password}")
	public ResponseEntity<?> findUsuarioByUsuarioAndPassword(@PathVariable String user, @PathVariable String password) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findUsuarioByUsuarioAndPassword(user, password));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
		}
	}
	
	@GetMapping("/login/{user}")
	public ResponseEntity<?> findUsuarioByUsuarioAndPassword(@PathVariable String user) {
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findUsuarioByUsuario(user));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
		}
	}
}
