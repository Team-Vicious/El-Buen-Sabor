package com.el.buen.sabor.service;


import java.util.Date;
import java.util.List;

import com.el.buen.sabor.entity.Pedido;
import com.formaciondbi.microservicios.generics.services.Services;

public interface PedidoService extends Services<Pedido, Long>{
	public List<Pedido> findPedidosByClienteId(Long id);
	
	public void reporteIngresos(Date fechaInicio, Date fechaDestino);
	
	public void reporteRankingPedidos(Date fechaInicio, Date fechaDestino);
	
	public void reporteGanancias(Date fechaInicio, Date fechaDestino);
	
	public void reporteCantidadPedidosPorCliente(Date fechaInicio, Date fechaDestino);
	
	public Pedido findPedidoByFacturaId(Long id);
}
