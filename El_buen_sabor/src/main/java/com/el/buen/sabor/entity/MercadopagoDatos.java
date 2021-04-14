package com.el.buen.sabor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mercadoPago_datos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadopagoDatos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 300)
	private Long identidicadorPago;
	
	private Date fechaCreacion;
	
	private Date fechaAprobacion;
	
	@Column(length = 30)
	private String formaPago;
	
	@Column(length = 30)
	private String metodoPago;
	
	@Column(length = 30)
	private String nroTarjeta;
	
	@Column(length = 30)
	private String estado;

}
