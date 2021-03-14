package com.cadastrousuario.cadastrousuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cadastrousuario.cadastrousuario.models.Cargo;
import com.cadastrousuario.cadastrousuario.repository.CargoRepository;

@Controller
public class CargoController {
	
	@Autowired
	private CargoRepository cr;
	
	@RequestMapping(value="/cadastrarCargo", method=RequestMethod.GET)
	public String form() {
		
		return "cargo/formCargo";
		
	}
	
	@RequestMapping(value="/cadastrarCargo", method=RequestMethod.POST)
	public String form(Cargo cargo) {
		
		cr.save(cargo);
		
		return "redirect:/cadastrarCargo";
		
	}
}
