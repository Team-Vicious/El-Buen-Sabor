package com.el.buen.sabor.repository;

import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.Cliente;
import com.el.buen.sabor.entity.Domicilio;
import com.el.buen.sabor.entity.Usuario;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface ClienteRepository extends Repository<Cliente, Long>{

	@Query("select d from Cliente c join c.domicilio d where c.id=?1")
	public Domicilio findDomicilioByClienteId(Long id);
	
	@Query("select c from Usuario u join u.cliente c where u.id=?1")
	public Cliente findDomicilioByClientesId(Long id);

}
