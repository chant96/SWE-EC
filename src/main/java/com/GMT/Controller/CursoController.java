package com.GMT.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.ElementCollection;
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

import com.GMT.Entidad.Curso;
import com.GMT.Entidad.Estudiante;
import com.GMT.Entidad.Horario;
import com.GMT.Entidad.Instructor;
import com.GMT.Services.CertificadoServiceImpl;
import com.GMT.Services.CursoServiceImpl;
import com.GMT.Services.InstructorServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Curso")
public class CursoController {

	@Autowired
	private CursoServiceImpl cursoServiceImpl;
	@Autowired
	private InstructorServiceImpl instructorServiceImpl;
	@Autowired
	private CertificadoServiceImpl certificadoServiceImpl;
	@ElementCollection
    private List<Horario> listaHorarios=  new ArrayList<Horario>();
	
	ObjectMapper Obj = new ObjectMapper();
	
	//PAGINADO
		@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
		public String paginado(@RequestParam Map<String,Object> params, Model model) {
			
			 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
			 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
			 int tamanioPaginado= params.get("pageSize") != null ? (Integer.valueOf(params.get("pageSize").toString()) ) : 10; 
			 
			 PageRequest pageRequest=PageRequest.of(page, tamanioPaginado); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMA�O DE PAGINA
			 
			 Page<Curso> pageCurso=cursoServiceImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE ESTUDIANTES
			 int primeraFila=0;
			 int ultimaFila=0;
			 
			 int totalPage = pageCurso.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
			 if(pageCurso.getTotalElements()>0)primeraFila=1; //SI EXISTEN ELEMENTOS SE INICIALIZA EN 1 
			 primeraFila=primeraFila+(tamanioPaginado*page); // OBTENEMOS EL NUMERO DEL PRIMER REGISTRO DEL PAGINADO
			 ultimaFila=pageCurso.getContent().size()+(tamanioPaginado*page); //OBTENEMOS LA ULTIMA FILA
			 
			 if(totalPage>0) {
				//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
				 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
				 model.addAttribute("pages",pages);
			 }
			 String informacionPaginado="Mostrando "+primeraFila+" al "+ultimaFila+" de "+pageCurso.getTotalElements()+" registros";
			 
			 model.addAttribute("activo",4);
			 model.addAttribute("lista",pageCurso.getContent());
			 model.addAttribute("tamanioPaginado",tamanioPaginado);
			 model.addAttribute("selectedPageSize",tamanioPaginado);
			 model.addAttribute("current",page+1); //PAGINA ACTUAL
			 model.addAttribute("next",page+2); //SIGUENTE PAGINA
			 model.addAttribute("prev",page); //PAGINA ANTERIOR
			 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
			 model.addAttribute("info",informacionPaginado); //INFO 
			 model.addAttribute("html","GestionarCurso/listarCurso");
			 model.addAttribute("template","listarCurso");
			 return "fragments/layout";	 
		}
	
	//CREAR
		@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
		public String registro( Model model) {
			
		 listaHorarios.clear();
		 List<Integer>horas=IntStream.rangeClosed(0, 23).boxed().collect(Collectors.toList()); 
		 List<Integer>minutos=IntStream.rangeClosed(0, 59).boxed().collect(Collectors.toList()); 
		 model.addAttribute("activo",4);
		 model.addAttribute("horas",horas);
		 model.addAttribute("minutos",minutos);
		 model.addAttribute("listaDocentes",instructorServiceImpl.listar());
		 model.addAttribute("listaCertificado",certificadoServiceImpl.listar());
		 model.addAttribute("curso",new Curso());
		 model.addAttribute("html","GestionarCurso/registrarCurso");
		 model.addAttribute("template","registrarCurso");
		 return "fragments/layout";	
		}
	
	//CREAR
	/*@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardar(Curso entity, Model model) {
		
		//entity.getHorario().setPeriodo("3");
		
		cursoServiceImpl.Insertar(entity);
		return "redirect:/Curso/Paginado";
	}*/
		
		@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
		public @ResponseBody String guardar(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
			
			Curso entity= Obj.readValue(request.getParameter("Curso"),Curso.class);
			cursoServiceImpl.Insertar(entity);
			 return request.getParameter("Guardado correctamente");
		}
	
	
	//ACTUALIZAR
		@RequestMapping(value= {"/Editar/{id}"},method=RequestMethod.GET)
		public String editar( @PathVariable("id") int id, Model model) {
			
			
			Curso entity=cursoServiceImpl.buscar(id);
			
			if(entity==null) {
				 return "redirect:/Curso/Paginado";
			}
			 model.addAttribute("activo",4);
			 model.addAttribute("curso",entity);
			 model.addAttribute("listaDocentes",instructorServiceImpl.listar());
			 model.addAttribute("listaCertificado",certificadoServiceImpl.listar());
			 model.addAttribute("html","GestionarCurso/registrarCurso");
			 model.addAttribute("template","registrarCurso");
			 return "fragments/layout";	
		}
	
	//ELIMINAR
	@RequestMapping(value= {"/Eliminar"},method=RequestMethod.POST)
	public String eliminar(@RequestParam Map<String,Object> params, Model model) {
		
		int id= params.get("id") != null ? (Integer.valueOf(params.get("id").toString())) : 0 ;  
		Curso entity=cursoServiceImpl.buscar(id);
		if(entity!=null) {
			cursoServiceImpl.eliminar(entity);
		}
		
		 return "redirect:/Curso/Paginado";
	}
	
}
