package com.CodersTeam.ParaCasa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodersTeam.ParaCasa.entity.Producto;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	
	
	
	@Query(value="select * from Producto where id not in (select id_producto from menu_producto where id_menu=?)",nativeQuery=true)
	Iterable<Producto> listarDisponiblesParaMenu(long id);
}
