package com.el.buen.sabor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.Pedido;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface PedidoRepository extends Repository<Pedido, Long>{

	@Query("select p from Cliente c join c.pedido p where c.id=?1")
	public List<Pedido> findPedidosByClienteId(Long id);
	
	
}
