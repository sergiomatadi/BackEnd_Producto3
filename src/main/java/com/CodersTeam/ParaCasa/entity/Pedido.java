package com.CodersTeam.ParaCasa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private LocalDateTime fecha;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="id_usuario",nullable=false)
	private Usuario usuario;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="menu_pedido",joinColumns=@JoinColumn(name="id_pedido"),inverseJoinColumns=@JoinColumn(name="id_menu"))
	private List<Menu> menus=new ArrayList<>();
	
	public Pedido() {
		
	}

	public Pedido(Long id, LocalDateTime fecha, Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Menu> getMenus() {
		return menus;
	}
	
	
	

}
