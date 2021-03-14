package com.cadastrousuario.cadastrousuario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CargoController {
	
	@RequestMapping("/cadastrarCargo")
	public String form() {
		
		return "cargo/formCargo";
		
	}
}
