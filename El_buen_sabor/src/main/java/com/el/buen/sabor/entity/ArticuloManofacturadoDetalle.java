package com.el.buen.sabor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="articulo_manofacturado_detalle")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManofacturadoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	private double cantidad;
		
	@Column(length = 300)
	private String unidadMedida;
	
	@ManyToOne
	private ArticuloInsumo articuloInsumo;
	
	@ManyToOne
	@JsonIgnore
	private ArticuloManofacturado articuloManofacturado;

	
	private Date fechaBaja;
}
