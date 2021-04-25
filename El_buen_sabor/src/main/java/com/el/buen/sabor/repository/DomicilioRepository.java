package com.el.buen.sabor.repository;

import org.springframework.data.jpa.repository.Query;


import com.el.buen.sabor.entity.Domicilio;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface DomicilioRepository extends Repository<Domicilio, Long>{

	
	@Query("select d from Cliente c inner join c.domicilio d where c.id=?1")
	public Domicilio findDomicilioByClienteId(Long id);
}
