package com.CodersTeam.ParaCasa.repository;

import org.springframework.data.repository.CrudRepository;

import com.CodersTeam.ParaCasa.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	/*
	Pedido findById(long id);

	
	Iterable<Pedido> findAll();
	*/
}
