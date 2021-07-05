package com.el.buen.sabor.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.checkerframework.common.aliasing.qual.Unique;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuario")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="email no puede ser vacío")
	@Email
	@Column(length = 30)
	private String usuario;
	
	@NotEmpty
	@Column(length = 70)
	private String clave;
	
	@Column(length = 30)
	private String rol;
	
	private Date fechaBaja;
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Cliente cliente;
	
	
}
