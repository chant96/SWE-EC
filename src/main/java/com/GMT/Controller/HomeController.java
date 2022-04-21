package com.GMT.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	ObjectMapper Obj = new ObjectMapper();
	
	@RequestMapping(value= {"/","/login"},method=RequestMethod.GET)
	public String listarCompra() {
		
		return "GestionarUsuario/login";
	}
	
	
	@RequestMapping(value= {"/Home"},method=RequestMethod.GET)
	public String Home(Model model,Principal principal) {
		
		 /*Usuario usuario=usuarioServiceImpl.findByUsername(principal.getName());
		model.addAttribute("email",usuario.getEmail());
		 model.addAttribute("nombreCompleto",usuario.getNombres()+" "+usuario.getApellidos());
		 if(usuario.getAutorizacion().equals("ROLE_ADMIN")) model.addAttribute("tipoDeUsuario","Administrador");
		 else model.addAttribute("tipoDeUsuario","Usuario");
		 */
		
		// model.addAttribute("titulo","Sistema Servicio Mecanico.");
		model.addAttribute("activeInicio","active");
		model.addAttribute("html","home");
		 model.addAttribute("template","home");
		 return "fragments/layout";	
	}
}

