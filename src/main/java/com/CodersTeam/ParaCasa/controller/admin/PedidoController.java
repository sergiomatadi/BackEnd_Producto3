package com.CodersTeam.ParaCasa.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CodersTeam.ParaCasa.entity.Pedido;
import com.CodersTeam.ParaCasa.repository.PedidoRepository;


@Controller
public class PedidoController {
	
	@Autowired
	PedidoRepository pedRep;
	
	@GetMapping("/admin/pedidos")
	public ModelAndView urlPedidos() {
		Iterable<Pedido> pedidos= pedRep.findAll();
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/views/pedidos/listarPedidos.html");
		mv.addObject("pedidos",pedidos);
		
		return mv;
	}
	

}
