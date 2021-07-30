package com.el.buen.sabor.service;

import com.el.buen.sabor.entity.DetallePedido;

public interface DetallePedidoService {
	
	public void reducirStock(DetallePedido[] detallesPedido) throws Exception;

}
