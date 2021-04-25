package com.el.buen.sabor.repository;


import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.MercadopagoDatos;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface MercadopagoDatosRepository extends Repository<MercadopagoDatos, Long>{

	@Query("select m from Pedido p join p.mercadopagoDatos m where p.id=?1")
	public MercadopagoDatos findMpdByPedidoId(Long id);
}
