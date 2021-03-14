package com.cadastrousuario.cadastrousuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cadastrousuario.cadastrousuario.models.Cargo;
import com.cadastrousuario.cadastrousuario.models.Usuario;
import com.cadastrousuario.cadastrousuario.repository.CargoRepository;
import com.cadastrousuario.cadastrousuario.repository.UsuarioRepository;

@Controller
public class CargoController {
	
	@Autowired
	private CargoRepository cr;
	
	@Autowired
	private UsuarioRepository ur;
	
	@RequestMapping(value="/cadastrarCargo", method=RequestMethod.GET)
	public String form() {
		
		return "cargo/formCargo";
		
	}
	
	@RequestMapping(value="/cadastrarCargo", method=RequestMethod.POST)
	public String form(Cargo cargo) {
		
		cr.save(cargo);
		
		return "redirect:/cadastrarCargo";
		
	}
	
	@RequestMapping("/cargos")
	public ModelAndView listaCargos() {
		ModelAndView mv = new ModelAndView("/index");
		Iterable<Cargo> cargos = cr.findAll();
		mv.addObject("cargos", cargos);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesCargo(@PathVariable("codigo") long codigo) {
		Cargo cargo = cr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("cargo/detalhesCargo");
		mv.addObject("cargo", cargo);
		
		Iterable<Usuario> usuarios = ur.findByCargo(cargo);
		mv.addObject("usuarios", usuarios);
		
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesCargoPost(@PathVariable("codigo") long codigo, Usuario usuario) {
		Cargo cargo = cr.findByCodigo(codigo);
		usuario.setCargo(cargo);
		ur.save(usuario);
		return "redirect:/{codigo}";
	}
	
	
}
