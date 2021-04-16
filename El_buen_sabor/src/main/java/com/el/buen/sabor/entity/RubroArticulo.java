package com.el.buen.sabor.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rubro_articulo")
@Setter
@Getter
@AllArgsConstructor
public class RubroArticulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 300)
	private String denominacion;
	
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private List<RubroArticulo> rubroArticulo;
	
	@JsonIgnoreProperties(value = {"hijos", "handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	private RubroArticulo padre;
	
	@JsonIgnoreProperties(value = {"padre", "handler", "hibernateLazyInitializer"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "padre", cascade = CascadeType.ALL)
	private List<RubroArticulo> hijos;

	public RubroArticulo() {
		this.hijos = new ArrayList<>();
	}
	
}
