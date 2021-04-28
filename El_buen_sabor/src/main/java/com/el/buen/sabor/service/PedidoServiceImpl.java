package com.el.buen.sabor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.Pedido;
import com.el.buen.sabor.repository.PedidoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class PedidoServiceImpl extends ServicesImpl<Pedido, Long> implements PedidoService{

	@Autowired
	PedidoRepository repository;

	@Override
	public List<Pedido> findPedidosByClienteId(Long id) {
		
		return repository.findPedidosByClienteId(id);
	}
}
