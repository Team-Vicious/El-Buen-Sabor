package com.el.buen.sabor.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.el.buen.sabor.entity.Pedido;
import com.formaciondbi.microservicios.generics.repository.Repository;

@org.springframework.stereotype.Repository
public interface PedidoRepository extends Repository<Pedido, Long>{

	@Query("select p from Cliente c join c.pedido p where c.id=?1")
	public List<Pedido> findPedidosByClienteId(Long id);
	
	@Query("select p from Pedido p join p.factura f where f.id=?1")
	public Pedido findPedidoByFacturaId(Long id);
	
	@Transactional
	@Modifying
	@Query(value="{call reporteIngresos(:fechaInicio, :fechaDestino )}",nativeQuery = true)
	public void reporteIngresos(@Param("fechaInicio") Date fechaInicio,@Param("fechaDestino") Date fechaDestino );
	
	@Transactional
	@Modifying
	@Query(value="{call rankingArticulosManufacturadosVendidos(:fechaInicio, :fechaDestino )}",nativeQuery = true)
	public void reporteRankingPedidos(@Param("fechaInicio") Date fechaInicio,@Param("fechaDestino") Date fechaDestino );
	
	
	@Transactional
	@Modifying
	@Query(value="{call reporteGanancias(:fechaInicio, :fechaDestino )}",nativeQuery = true)
	public void reporteGanancias(@Param("fechaInicio") Date fechaInicio,@Param("fechaDestino") Date fechaDestino );
	
	@Transactional
	@Modifying
	@Query(value="{call cantidadPedidosPorCliente(:fechaInicio, :fechaDestino )}",nativeQuery = true)
	public void reporteCantidadPedidosPorCliente(@Param("fechaInicio") Date fechaInicio,@Param("fechaDestino") Date fechaDestino );
	
	
}
