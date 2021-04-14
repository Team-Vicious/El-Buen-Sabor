package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.Domicilio;
import com.el.buen.sabor.repository.ArticuloInsumoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class DomicilioServiceImpl extends ServicesImpl<Domicilio, Long> implements DomicilioService{

	@Autowired
	ArticuloInsumoRepository repository;
}
