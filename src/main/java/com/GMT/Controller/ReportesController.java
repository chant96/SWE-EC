package com.GMT.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GMT.Entidad.Maquina;
import com.GMT.Services.CursoServiceImpl;
import com.GMT.Services.MaquinaServiceImpl;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/Reporte")
public class ReportesController {
	
	//CONEXION BASE DE DATOS ACTUAL
	@Autowired
	protected DataSource datasource;
	
	@Autowired
	private MaquinaServiceImpl maquinaServiceImpl;
	
	@Autowired
	private CursoServiceImpl cursoServiceImpl;
	
	//LISTAR RESPORTES 
	@RequestMapping(value= {"/Lista"},method=RequestMethod.GET)
	public String listaReportes(Model model) {
		
		 model.addAttribute("activo",7);
		 model.addAttribute("listaMaquina",maquinaServiceImpl.listar());
		 model.addAttribute("listaCurso",cursoServiceImpl.listar());
		 model.addAttribute("maquina",new Maquina());
		 model.addAttribute("html","GestionarReporte/Reportes");
		 model.addAttribute("template","listarReportes");
		 return "fragments/layout";	
	}
	
	
	//DESCARGAR REPORTE EN PDF
	@RequestMapping(value = "/DescargarPDF", method = RequestMethod.GET)
	  @ResponseBody
	  public void descargaPDF(HttpServletResponse response) throws  IOException, JRException, SQLException {
		  
	    InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/Invoice.jasper");
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,datasource.getConnection());
	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=historialEstudiantes.pdf");
	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    
	  }
	
	//VISUALIZAR REPORTE EN PDF
	@RequestMapping(value ="/VistaPrevia", method = RequestMethod.GET)
    public void vistaPreviaPDF( HttpServletRequest request,HttpServletResponse response) throws  Exception{


		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/Invoice.jasper");
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }
	
	@RequestMapping(value ="/Inscripcion/{idInscripcion}", method = RequestMethod.GET)
    public void vistaPreviaInscripcionPDF( HttpServletRequest request,HttpServletResponse response,@PathVariable(value="idInscripcion") int idInscripcion) throws  Exception{


		File fichero = new File("src/main/webapp/reportes");
		System.out.print("\n ruta :"+fichero.getAbsolutePath()+"\n");
				
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/inscripcion.jasper");
		Map<String,Object> params = new HashMap();
		params.put("path", fichero.getAbsolutePath());
		params.put("idInscripcion", idInscripcion);
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }
	
	@RequestMapping(value ="/MorososMaquina/{idMaquina}", method = RequestMethod.GET)
    public void vistaPreviaMorososMaquinaPDF( HttpServletRequest request,HttpServletResponse response,@PathVariable(value="idMaquina") int idMaquina) throws  Exception{


		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/EstudiantesPorTipoDeMaquina.jasper");
		Map<String,Object> params = new HashMap();
		params.put("idMaquina", idMaquina);
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }
	
	@RequestMapping(value ="/MorososCurso/{idCurso}", method = RequestMethod.GET)
    public void vistaPreviaMorososCursoPDF( HttpServletRequest request,HttpServletResponse response,@PathVariable(value="idCurso") int idCurso) throws  Exception{


		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/EstudiantesPorTipoDeCurso.jasper");
		Map<String,Object> params = new HashMap();
		params.put("idCurso", idCurso);
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }
	
	@RequestMapping(value ="/Morosos", method = RequestMethod.GET)
    public void vistaPreviaMorososPDF( HttpServletRequest request,HttpServletResponse response) throws  Exception{



		//InputStream jasperStream = request.getSession().getServletContext().getResourceAsStream("/reportes/ EstudiantesMorosos.jasper");
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/EstudiantesMorosos.jasper");
		//InputStream jasperStream = this.getClass().getResourceAsStream("/Reportes/EstudiantesMorosos.jasper");

	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }

	

}
