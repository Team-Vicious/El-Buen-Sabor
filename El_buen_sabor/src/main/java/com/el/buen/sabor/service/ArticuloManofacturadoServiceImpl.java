package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.ArticuloManofacturado;
import com.el.buen.sabor.repository.ArticuloManofacturadoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class ArticuloManofacturadoServiceImpl extends ServicesImpl<ArticuloManofacturado, Long> implements ArticuloManofacturadoService{

	@Autowired
	ArticuloManofacturadoRepository repository;

	@Override
	public ArticuloManofacturado findArticuloManofacturadoById(Long id) {
		return repository.findArticuloManofacturadoById(id);
	}
}
