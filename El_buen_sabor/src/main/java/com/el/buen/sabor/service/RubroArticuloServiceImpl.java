package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.RubroArticulo;
import com.el.buen.sabor.repository.ArticuloInsumoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class RubroArticuloServiceImpl extends ServicesImpl<RubroArticulo, Long> implements RubroArticuloService{

	@Autowired
	ArticuloInsumoRepository repository;
}
