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
@Table(name="cliente")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 300)
	private int numero;
	
	private Date fecha;
	
	@Column(length = 30)
	private int estado;
	
	private Date horaEstimadaFin;
	
	@Column(length = 30)
	private int tipoEnvio;
	
	@Column(length = 30)
	private double total;

}
