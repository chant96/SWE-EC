package com.GMT.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GMT.Entidad.Maquina;
import com.GMT.Services.MaquinaServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Maquina")
public class MaquinaController {
	
	ObjectMapper Obj = new ObjectMapper();
	
	@Autowired
	private MaquinaServiceImpl maquinaServiceImpl;
	
	//PAGINADO
	@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
	public String paginado(@RequestParam Map<String,Object> params, Model model) {
		
		 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
		 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
		 int tamanioPaginado= params.get("pageSize") != null ? (Integer.valueOf(params.get("pageSize").toString()) ) : 10; 
		 
		 PageRequest pageRequest=PageRequest.of(page, tamanioPaginado); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMAÑO DE PAGINA
		 
		 Page<Maquina> pageCertificado=maquinaServiceImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE ESTUDIANTES
		 int primeraFila=0;
		 int ultimaFila=0;
		 
		 int totalPage = pageCertificado.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
		 if(pageCertificado.getTotalElements()>0)primeraFila=1; //SI EXISTEN ELEMENTOS SE INICIALIZA EN 1 
		 primeraFila=primeraFila+(tamanioPaginado*page); // OBTENEMOS EL NUMERO DEL PRIMER REGISTRO DEL PAGINADO
		 ultimaFila=pageCertificado.getContent().size()+(tamanioPaginado*page); //OBTENEMOS LA ULTIMA FILA
		 
		
		 if(totalPage>0) {
			//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
			 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
			 model.addAttribute("pages",pages);
		 }
		 
		 String informacionPaginado="Mostrando "+primeraFila+" al "+ultimaFila+" de "+pageCertificado.getTotalElements()+" registros";
		 model.addAttribute("activo",6);
		 model.addAttribute("tamanioPaginado",tamanioPaginado);
		 model.addAttribute("selectedPageSize",tamanioPaginado);
		 model.addAttribute("lista",pageCertificado.getContent());
		 model.addAttribute("current",page+1); //PAGINA ACTUAL
		 model.addAttribute("next",page+2); //SIGUENTE PAGINA
		 model.addAttribute("prev",page); //PAGINA ANTERIOR
		 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
		 model.addAttribute("info",informacionPaginado); //INFO 
		 model.addAttribute("html","GestionarMaquina/listarMaquina");
		 model.addAttribute("template","listarMaquina");
		 return "fragments/layout";	 
	}

	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String guardarMaquinaGET(Model model) {
		
		 model.addAttribute("maquina",new Maquina());
		 model.addAttribute("activo",6);
		 model.addAttribute("html","GestionarMaquina/registrarMaquina");
		 model.addAttribute("template","registrarMaquina");
		 return "fragments/layout";	
	}
	
	//CREAR
	/*@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardarMaquinaPOST(Maquina entity, Model model) {
		
		maquinaServiceImpl.guardar(entity);
		return "redirect:/Maquina/Paginado";
	}*/
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public @ResponseBody String guardar(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		
		Maquina entity= Obj.readValue(request.getParameter("Maquina"),Maquina.class);
		maquinaServiceImpl.guardar(entity);
		 return request.getParameter("Guardado correctamente");
	}
	
	//ACTUALIZAR
	@RequestMapping(value= {"/Editar/{id}"},method=RequestMethod.GET)
	public String registro( @PathVariable("id") int id, Model model) {
		
		
		Maquina entity=maquinaServiceImpl.buscar(id);
		
		if(entity==null) {
			 return "redirect:/Maquina/Paginado";
		}
		
		 model.addAttribute("maquina",entity);
		 model.addAttribute("activo",6);
		 model.addAttribute("html","GestionarMaquina/registrarMaquina");
		 model.addAttribute("template","registrarMaquina");
		 return "fragments/layout";	
	}
	
	//ELIMINAR
	@RequestMapping(value= {"/Eliminar"},method=RequestMethod.POST)
	public String eliminar(@RequestParam Map<String,Object> params, Model model) {
		
		int id= params.get("id") != null ? (Integer.valueOf(params.get("id").toString())) : 0 ; 
		Maquina entity=maquinaServiceImpl.buscar(id);
		
		if(entity!=null) {
			maquinaServiceImpl.eliminar(entity);
		}
		
		 return "redirect:/Maquina/Paginado";
	}
	
}
