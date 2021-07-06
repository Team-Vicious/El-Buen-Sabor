package com.el.buen.sabor.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.Pedido;
import com.el.buen.sabor.entity.Reporte;
import com.el.buen.sabor.service.PedidoService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/pedido")
public class PedidoController extends ControllerImpl<Pedido, ServicesImpl<Pedido,Long>>{

	@Autowired
	PedidoService service;
	
	@GetMapping("/pedidos-clienteId/{id}")
	ResponseEntity<?> findPedidosByClienteId(@PathVariable Long id){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosByClienteId(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
		}
	}
	
	@PostMapping("/pedido-mp")
    public ResponseEntity<?> save(@RequestBody Pedido pedido){
        
    	
    	try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(pedido));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde.\"}");
        	
        }
    }
	
	@PostMapping("/reporte-ingresos")
    public ResponseEntity<?> reporteIngresos(@RequestBody Reporte fechas){
    	
    	try {
    		service.reporteIngresos(fechas.getFechaInicio(),fechas.getFechaDestino());
    		return ResponseEntity.status(HttpStatus.OK).body("Reporte Generado");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde.\"}"+e);
        	
        }
    }
	
	@PostMapping("/reporte-ranking")
    public ResponseEntity<?> reporteRankingPedidos(@RequestBody Reporte fechas){
    	
    	try {
    		service.reporteRankingPedidos(fechas.getFechaInicio(),fechas.getFechaDestino());
    		return ResponseEntity.status(HttpStatus.OK).body("Reporte Generado");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde.\"}"+e);
        	
        }
    }
	
	@PostMapping("/reporte-ganancias")
    public ResponseEntity<?> reporteGanancias(@RequestBody Reporte fechas){
    	
    	try {
    		service.reporteGanancias(fechas.getFechaInicio(),fechas.getFechaDestino());
    		return ResponseEntity.status(HttpStatus.OK).body("Reporte Generado");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde.\"}"+e);
        	
        }
    }
	
	@PostMapping("/reporte-pedidosusuario")
    public ResponseEntity<?> reporteCantidadPedidosPorCliente(@RequestBody Reporte fechas){
    	
    	try {
    		service.reporteCantidadPedidosPorCliente(fechas.getFechaInicio(),fechas.getFechaDestino());
    		return ResponseEntity.status(HttpStatus.OK).body("Reporte Generado");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde.\"}"+e);
        	
        }
    }
	
	@GetMapping("/pedido-facturaId/{id}")
	ResponseEntity<?> findPedidoByFacturaId(@PathVariable Long id){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidoByFacturaId(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde.\"}"+e.getMessage());
			
		}
	}
	
	
}
