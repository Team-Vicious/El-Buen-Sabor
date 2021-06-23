package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.Usuario;
import com.el.buen.sabor.repository.UsuarioRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class UsuarioServiceImpl extends ServicesImpl<Usuario, Long> implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public Usuario findUsuarioByClienteId(Long id) {
		return repository.findUsuarioByClienteId(id);
	}

	@Override
	public Usuario findUsuarioByUsuarioAndPassword(String usuario, String constraseña) {
		
		return repository.findUsuarioByUsuarioAndPassword(usuario, constraseña);
	}

	@Override
	public Usuario findUsuarioByUsuario(String usuario) {
		
		return repository.findUsuarioByUsuario(usuario);
	}
	
}
