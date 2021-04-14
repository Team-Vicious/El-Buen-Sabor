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
@Table(name="factura")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha;
	
	@Column(length = 30)
	private int numero;
	
	@Column(length = 30)
	private double montoDescuento;
	
	@Column(length = 30)
	private String formaPago;
	
	@Column(length = 30)
	private String nroTarjeta;
	
	@Column(length = 30)
	private double totalVenta;
	
	@Column(length = 30)
	private double totalCosto;

}
