package com.el.buen.sabor.service;

import java.util.List;

import com.el.buen.sabor.entity.Pedido;
import com.formaciondbi.microservicios.generics.services.Services;

public interface PedidoService extends Services<Pedido, Long>{
	public List<Pedido> findPedidosByClienteId(Long id);
}
