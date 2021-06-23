package com.el.buen.sabor.service;

import com.el.buen.sabor.entity.Usuario;
import com.formaciondbi.microservicios.generics.services.Services;

public interface UsuarioService extends Services<Usuario, Long>{
	
	public Usuario findUsuarioByClienteId(Long id);
	
	public Usuario findUsuarioByUsuarioAndPassword(String usuario,String constraseña);
	
	public Usuario findUsuarioByUsuario(String usuario);

}
