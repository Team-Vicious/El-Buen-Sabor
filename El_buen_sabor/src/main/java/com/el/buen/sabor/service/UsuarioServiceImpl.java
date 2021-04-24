package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.Usuario;
import com.el.buen.sabor.repository.ArticuloInsumoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class UsuarioServiceImpl extends ServicesImpl<Usuario, Long> implements UsuarioService{

	@Autowired
	ArticuloInsumoRepository repository;
	
	@Override
	public Usuario findUsuarioByClienteId(Long id) {
		return null;
	}
}
