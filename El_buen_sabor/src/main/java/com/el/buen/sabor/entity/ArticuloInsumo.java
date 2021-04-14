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
@Table(name="articulo_insumo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 300)
	private String denominacion;
	
	@Column(length = 30)
	private double precioCompra;
	
	@Column(length = 30)
	private double precioVenta;
	
	@Column(length = 30)
	private double stockActual;
	
	@Column(length = 30)
	private double stockMinimo;
	
	@Column(length = 128)
	private String unidadMedida;
	
	
	private boolean esInsumo;

}
