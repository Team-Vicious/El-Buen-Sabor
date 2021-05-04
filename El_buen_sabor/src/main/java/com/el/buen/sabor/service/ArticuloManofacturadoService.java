package com.el.buen.sabor.service;

import com.el.buen.sabor.entity.ArticuloManofacturado;
import com.formaciondbi.microservicios.generics.services.Services;

public interface ArticuloManofacturadoService extends Services<ArticuloManofacturado, Long> {
	
	public ArticuloManofacturado findArticuloManofacturadoById(Long id);
	
}
