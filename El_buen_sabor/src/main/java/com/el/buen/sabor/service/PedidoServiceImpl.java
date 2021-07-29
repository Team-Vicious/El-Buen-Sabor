package com.el.buen.sabor.service;

import java.util.Date;
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

	@Override
	public void reporteIngresos(Date fechaInicio, Date fechaDestino) {
		repository.reporteIngresos( fechaInicio,  fechaDestino);
		
	}

	@Override
	public void reporteRankingPedidos(Date fechaInicio, Date fechaDestino) {
		repository.reporteRankingPedidos(fechaInicio, fechaDestino);
		
	}

	@Override
	public void reporteGanancias(Date fechaInicio, Date fechaDestino) {
		repository.reporteGanancias(fechaInicio, fechaDestino);
		
	}

	@Override
	public void reporteCantidadPedidosPorCliente(Date fechaInicio, Date fechaDestino) {
		repository.reporteCantidadPedidosPorCliente(fechaInicio, fechaDestino);
		
	}
	
	@Override
	public void reportePedidos(Date fechaInicio, Date fechaDestino) {
		repository.reportePedidos(fechaInicio, fechaDestino);
		
	}

	@Override
	public Pedido findPedidoByFacturaId(Long id) {
		
		return repository.findPedidoByFacturaId(id);
	}

	@Override
	public List<Pedido> findPedidosTipoEstado(int estado) {
		
		return repository.findPedidosTipoEstado(estado);
	}

	@Override
	public List<Pedido> findPedidosTipoEnvio(int tipoEnvio) {
		
		return repository.findPedidosTipoEnvio(tipoEnvio);
	}

	
	
}
