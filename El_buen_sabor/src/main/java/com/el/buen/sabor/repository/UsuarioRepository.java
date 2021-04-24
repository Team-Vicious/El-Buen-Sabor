package com.el.buen.sabor.repository;


import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.Usuario;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface UsuarioRepository extends Repository<Usuario, Long>{
	
	@Query("select usuario from Usuario usuario join fetch usuario.cliente cli where cli.id=?1")
	public Usuario findUsuarioByClienteId(Long id);

}
