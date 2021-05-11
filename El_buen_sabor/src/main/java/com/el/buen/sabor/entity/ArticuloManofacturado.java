package com.el.buen.sabor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	//@Column(length = 50)
	//private String imagen;
	
	
	@Lob //esta annotation permite guardar en ddbb objetos como fotos, pdf, etc
	//esto es porque no nos interesa pasarlo por el json ya que al ser bytes es muy grande y el
	//json crece exponencialmente y no nos conviene	
	@Column
	private byte[] imagen;	
	
	
	//este metodo es para que despues en el front nos retorne un codigo distinto de cada foto
	public Integer getFotoHashCode() {
		//puede no haber imagen, en ese caso retorna un null
		return (this.imagen!=null) ? this.imagen.hashCode():null;
			
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<ArticuloManofacturadoDetalle> articuloManofacturadoDetalle;
	
	@ManyToOne
	private RubroGeneral rubroGeneral;
	

}
