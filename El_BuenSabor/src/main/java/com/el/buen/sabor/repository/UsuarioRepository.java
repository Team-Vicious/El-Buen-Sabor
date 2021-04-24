package com.el.buen.sabor.repository;



import org.springframework.data.jpa.repository.Query;

import com.el.buen.sabor.entity.Usuario;
import com.el.buen.sabor.service.UsuarioService;
import com.formaciondbi.microservicios.generics.repository.Repository;

public interface UsuarioRepository extends Repository<Usuario, Long>{

	@Query("select * from Usuario")
	public Usuario buscarUsuario();
}
