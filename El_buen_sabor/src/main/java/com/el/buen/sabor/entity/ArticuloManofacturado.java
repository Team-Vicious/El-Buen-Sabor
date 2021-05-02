package com.el.buen.sabor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="articulo_manofacturado")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManofacturado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private int tiempoEstimadoCocina;
	
	@Column(length = 300)
	private String denominacion;
	
	@Column(length = 30)
	private double precioVenta;
	
	@Column(length = 50)
	private String imagen;	
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<ArticuloManofacturadoDetalle> articuloManofacturadoDetalle;
	
	@ManyToOne
	private RubroGeneral rubroGeneral;
	

}
