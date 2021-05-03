package com.el.buen.sabor.repository;

import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.ArticuloManofacturado;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface ArticuloManofacturadoRepository extends Repository<ArticuloManofacturado, Long>{
	
	@Query("select a from ArticuloManofacturado a where a.id=?1 ")
	public ArticuloManofacturado findArticuloManofacturadoById(Long id); 

}
