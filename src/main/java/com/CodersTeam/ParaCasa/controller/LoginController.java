package com.CodersTeam.ParaCasa.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView login(@RequestParam("error") Optional<Boolean> loginFallido,@RequestParam("logout") Optional<Boolean> logout) {
		if(loginFallido.isPresent()) {
			System.out.println("Login fallido");
		}
		
		ModelAndView mv= new ModelAndView("views/login/login");
		return mv;
	}
}
