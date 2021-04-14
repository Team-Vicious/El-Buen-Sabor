package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.ArticuloManofacturadoDetalle;
import com.el.buen.sabor.repository.ArticuloInsumoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class ArticuloManofacturadoDetalleServiceImpl extends ServicesImpl<ArticuloManofacturadoDetalle, Long> implements ArticuloManofacturadoDetalleService{

	@Autowired
	ArticuloInsumoRepository repository;
}
