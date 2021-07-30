package com.el.buen.sabor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.buen.sabor.entity.ArticuloInsumo;
import com.el.buen.sabor.entity.ArticuloManofacturado;
import com.el.buen.sabor.entity.ArticuloManofacturadoDetalle;
import com.el.buen.sabor.entity.DetallePedido;
import com.el.buen.sabor.repository.ArticuloInsumoRepository;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@Service
public class DetallePedidoServiceImpl extends ServicesImpl<DetallePedido, Long> implements DetallePedidoService{

	@Autowired
	ArticuloInsumoRepository repository;
	
	@Transactional
	@Override
	public void reducirStock(DetallePedido[] detallesPedido) throws Exception{
		
		for (DetallePedido detallePedido : detallesPedido) {
			if(detallePedido.getArticuloManofacturado() != null) {
				ArticuloManofacturado articulomanof = detallePedido.getArticuloManofacturado();
				List<ArticuloManofacturadoDetalle> articulomanofDetalle = articulomanof.getArticuloManofacturadoDetalle();
				
				for (ArticuloManofacturadoDetalle articuloManufD : articulomanofDetalle) {
					ArticuloInsumo aux = articuloManufD.getArticuloInsumo();
					Optional<ArticuloInsumo> insumo = repository.findById(aux.getId());
					
					ArticuloInsumo entidad = insumo.get();
					
					double cantidad = articuloManufD.getCantidad();
					
					entidad.setStockActual(( entidad.getStockActual() - cantidad ));
					
					try {
						repository.save(entidad);
					} catch (Exception e) {
						throw new Exception(e.getMessage());
					}
					
				}
				
			}
			
			if(detallePedido.getArticuloInsumo() != null) {
				ArticuloInsumo bebida = detallePedido.getArticuloInsumo();
				
				double cantidad = detallePedido.getCantidad();
				
				bebida.setStockActual(( bebida.getStockActual() - cantidad));
				
				try {
					repository.save(bebida);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
				
				
			}
			
		}
		
	}
}
