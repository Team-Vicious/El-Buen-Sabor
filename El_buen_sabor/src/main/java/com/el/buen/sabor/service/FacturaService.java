package com.el.buen.sabor.service;

import com.el.buen.sabor.entity.Factura;
import com.formaciondbi.microservicios.generics.services.Services;

public interface FacturaService extends Services<Factura, Long>{
	public Factura findFacturaByPedidoId(Long id);
}
