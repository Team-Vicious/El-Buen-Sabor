package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.Usuario;
import com.el.buen.sabor.repository.UsuarioRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class UsuarioServiceImpl extends ServicesImpl<Usuario, Long> implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario buscarUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
