package com.el.buen.sabor.entity;

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
@Table(name="configuracion")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Configuracion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 10)
	private int cantidadCocineros;
	
	@Column(length = 40)
	private String emailEmpresa;
	
	@Column(length = 300)
	private String tokenMercadoPago;
}
