package com.el.buen.sabor.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(length = 40)
	private String nombre;
	
	@NotEmpty
	@Column(length = 40)
	private String apellido;
	
	@Column(length = 15)
	private Long telefono;
	
	
	@NotEmpty
	@Email
	@Column(length = 40)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Domicilio domicilio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	@JsonIgnore
	private List<Pedido> pedido;
	
	private Date fechaBaja;
	
	
}
