package com.el.buen.sabor.repository;


import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.Factura;
import com.formaciondbi.microservicios.generics.repository.Repository;

public interface FacturaRepository extends Repository<Factura, Long>{

	@Query("select f from Pedido p join p.factura f where p.id=?1")
	public Factura findFacturaByPedidoId(Long id);
}
