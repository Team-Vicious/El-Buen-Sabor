package com.el.buen.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.buen.sabor.entity.DetalleFactura;
import com.el.buen.sabor.service.ArticuloInsumoService;
import com.formaciondbi.microservicios.generics.controllers.ControllerImpl;
import com.formaciondbi.microservicios.generics.services.ServicesImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/detalleFactura")
public class DetalleFacturaController extends ControllerImpl<DetalleFactura, ServicesImpl<DetalleFactura,Long>>{

	@Autowired
	ArticuloInsumoService service;
}
