package com.el.buen.sabor.repository;

import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.Cliente;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface ClienteRepository extends Repository<Cliente, Long>{

	
	@Query("select c from Usuario u join u.cliente c where u.id=?1")
	public Cliente findClienteByUsuarioId(Long id);

}
