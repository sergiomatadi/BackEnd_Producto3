package com.CodersTeam.ParaCasa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CodersTeam.ParaCasa.entity.Role;
import com.CodersTeam.ParaCasa.entity.Usuario;
import com.CodersTeam.ParaCasa.repository.RoleRepository;
import com.CodersTeam.ParaCasa.repository.UsuarioRepository;

@Controller
public class RegistroController {
	
	@Autowired 
	private PasswordEncoder codificadorPassword;
	
	@Autowired
	private UsuarioRepository usuRep; 
	
	@Autowired
	private RoleRepository roleRep;
	
	@GetMapping("/registro")
	public ModelAndView registro() {
		ModelAndView mv= new ModelAndView("/views/login/registro");
		return mv;
	}
	
	@PostMapping("/realizarRegistro")
	public ModelAndView realizarRegistro(
			@RequestParam(name="nombre") String nombre,
			@RequestParam(name="usuario") String usuario,
			@RequestParam(name="correo") String correo,
			@RequestParam(name="dni") String dni,
			@RequestParam(name="password") String password
			
			) {
		
		String passwd=codificadorPassword.encode(password);
		System.out.println(passwd);
		Usuario u=new Usuario(null,nombre,dni,usuario,passwd, correo);
		Optional<Role> or=roleRep.findById(2L);
		Role role=or.get();
		u.setRole(role);
		usuRep.save(u);
		
		ModelAndView mv=new ModelAndView("/views/login/login");
		return mv;
	}
}
