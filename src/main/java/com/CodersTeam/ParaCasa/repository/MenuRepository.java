package com.CodersTeam.ParaCasa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.CodersTeam.ParaCasa.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	
	
	
	@Modifying
	@Transactional
	@Query(value="insert into menu_producto (id_producto,id_menu) values (?,?)",nativeQuery=true)
	void insertarProductoEnMenu(long id_producto,long id_menu);
	
	
	@Modifying
	@Transactional
	@Query(value="delete from menu_producto where id_producto=? and id_menu=?",nativeQuery=true)
	void eliminarProductoDelMenu(long id_producto,long id_menu);

	
}
