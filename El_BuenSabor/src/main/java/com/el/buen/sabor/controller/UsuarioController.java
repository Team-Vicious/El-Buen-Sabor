package com.el.buen.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.Usuario;
import com.el.buen.sabor.service.UsuarioService;
import com.el.buen.sabor.service.UsuarioServiceImpl;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/usuario")
public class UsuarioController extends ControllerImpl<Usuario, ServicesImpl<Usuario, Long>>{
	
	@Autowired
	UsuarioService usuarioService;

}
