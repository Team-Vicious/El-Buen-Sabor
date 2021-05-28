package com.el.buen.sabor.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pedido")
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
	
	private Date fechaBaja;
	
	@OneToOne
	private Domicilio domicilio;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Factura factura;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pedido")
	private List<DetallePedido> detallePedido;
	
	@OneToOne
	private MercadopagoDatos mercadopagoDatos; 
	
	@ManyToOne
	@JsonIgnore
	private Cliente cliente;

}
