package com.el.buen.sabor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.Factura;
import com.el.buen.sabor.repository.FacturaRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class FacturaServiceImpl extends ServicesImpl<Factura, Long> implements FacturaService{

	@Autowired
	FacturaRepository repository;

	@Override
	public Factura findFacturaByPedidoId(Long id) {
		
		return repository.findFacturaByPedidoId(id);
	}
}
