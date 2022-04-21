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

import com.GMT.Entidad.Instructor;
import com.GMT.Services.InstructorServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Instructor")
public class InstructorController {

	ObjectMapper Obj = new ObjectMapper();
	
	@Autowired
	private InstructorServiceImpl instructorServiceImpl;	
	
	@RequestMapping(value= {"/Listar"},method=RequestMethod.GET)
	public String listar(Model model) {
		
		 model.addAttribute("lista",instructorServiceImpl.listar());
		 model.addAttribute("html","GestionarInstructor/listarInstructor");
		 model.addAttribute("template","listarInstructor");
		 return "fragments/layout";	 
	}
	
	
	//PAGINADO
	@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
	public String paginado(@RequestParam Map<String,Object> params, Model model) {
		
		 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
		 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
		 int tamanioPaginado= params.get("pageSize") != null ? (Integer.valueOf(params.get("pageSize").toString()) ) : 10; 
		 
		 PageRequest pageRequest=PageRequest.of(page, tamanioPaginado); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMAÑO DE PAGINA
		 
		 Page<Instructor> pageInstructor=instructorServiceImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE INSTRUCTORES
		 int primeraFila=0;
		 int ultimaFila=0;
		 
		 int totalPage = pageInstructor.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
		 if(pageInstructor.getTotalElements()>0)primeraFila=1; //SI EXISTEN ELEMENTOS SE INICIALIZA EN 1 
		 primeraFila=primeraFila+(tamanioPaginado*page); // OBTENEMOS EL NUMERO DEL PRIMER REGISTRO DEL PAGINADO
		 ultimaFila=pageInstructor.getContent().size()+(tamanioPaginado*page); //OBTENEMOS LA ULTIMA FILA
		 
		 if(totalPage>0) {
			//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
			 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
			 model.addAttribute("pages",pages);
		 }
		 
		 String informacionPaginado="Mostrando "+primeraFila+" al "+ultimaFila+" de "+pageInstructor.getTotalElements()+" registros";
		 model.addAttribute("activo",3);
		 model.addAttribute("lista",pageInstructor.getContent());
		 model.addAttribute("tamanioPaginado",tamanioPaginado);
		 model.addAttribute("selectedPageSize",tamanioPaginado);
		 model.addAttribute("current",page+1); //PAGINA ACTUAL
		 model.addAttribute("next",page+2); //SIGUENTE PAGINA
		 model.addAttribute("prev",page); //PAGINA ANTERIOR
		 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
		 model.addAttribute("info",informacionPaginado); //INFO 
		 model.addAttribute("html","GestionarInstructor/listarInstructor");
		 model.addAttribute("template","listarInstructor");
		 return "fragments/layout";	 
	}
	
	//BUSCAR
		@RequestMapping(value= {"/Buscar"},method=RequestMethod.GET)
		public String buscar(@RequestParam Map<String,Object> params,Model model) {
			
			 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;  
			 String dni= params.get("dni") != null ? (params.get("dni").toString()) : "" ;  
			 int tamanioPaginado= params.get("pageSize") != null ? (Integer.valueOf(params.get("pageSize").toString()) ) : 10; 
			 
			 if(!dni.equals(""))
			 {
				 PageRequest pageRequest=PageRequest.of(page, tamanioPaginado); 
				 
				 
				 Page<Instructor> pageInstructor=instructorServiceImpl.buscar(dni,pageRequest); 
				 int totalPage = pageInstructor.getTotalPages(); 
				 
				 if(totalPage>0) {
					 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
					 model.addAttribute("pages",pages);
				 }
				 //System.out.print(pageEstudiante);
				 model.addAttribute("activo",3);
				 model.addAttribute("lista",pageInstructor.getContent());
				 model.addAttribute("current",page+1); //PAGINA ACTUAL
				 model.addAttribute("next",page+2); //SIGUENTE PAGINA
				 model.addAttribute("prev",page); //PAGINA ANTERIOR
				 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
				 model.addAttribute("html","GestionarInstructor/listarInstructor");
				 model.addAttribute("template","listarInstructor");
				 return "fragments/layout"; 
				 
			 }else {
				 return "redirect:/Instructor/Paginado";
			 }
			 
		}
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String registro( Model model) {
		
		model.addAttribute("instructor",new Instructor());
		 model.addAttribute("html","GestionarInstructor/registrarInstructor");
		 model.addAttribute("template","registrarInstructor");
		 return "fragments/layout";	
	}
	
	/*@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardar(Instructor entity, Model model) {
		
		 instructorServiceImpl.guardar(entity);
		 return "redirect:/Instructor/Paginado";
	}*/
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public @ResponseBody String guardar(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		
		Instructor entity= Obj.readValue(request.getParameter("Instructor"),Instructor.class);
		 instructorServiceImpl.guardar(entity);
		 return request.getParameter("Guardado correctamente");
	}
	
	@RequestMapping(value= {"/Editar/{dni}"},method=RequestMethod.GET)
	public String registro( @PathVariable("dni") String dni, Model model) {
		
		
		Instructor entity=instructorServiceImpl.buscarDni(dni);
		
		if(entity==null) {
			 return "redirect:/Instructor/Paginado";
		}
		
		model.addAttribute("activo",3);
		 model.addAttribute("instructor",entity);
		 model.addAttribute("html","GestionarInstructor/registrarInstructor");
		 model.addAttribute("template","registrarInstructor");
		 return "fragments/layout";	
	}
	
	@RequestMapping(value= {"/Eliminar"},method=RequestMethod.POST)
	public String eliminar(@RequestParam Map<String,Object> params, Model model) {
		
		String dni= params.get("dni") != null ? (params.get("dni").toString()) : "" ;  
		Instructor entity=instructorServiceImpl.buscarDni(dni);
		
		if(entity!=null) {
			instructorServiceImpl.eliminar(entity);
		}
		
		 return "redirect:/Instructor/Paginado";
	}
	
}