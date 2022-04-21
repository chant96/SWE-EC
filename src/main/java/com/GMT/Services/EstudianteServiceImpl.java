package com.GMT.Services;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Estudiante;
import com.GMT.Entidad.Paginado;
import com.GMT.Persistencia.IEstudianteDAO;

@Service
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante, String> implements IEstudianteService{

	@Autowired
	private IEstudianteDAO estudianteDAO;
	


	@Override
	public Estudiante buscarDni(String dni) {
		// TODO Auto-generated method stub
		return estudianteDAO.findBydni(dni);
	}

	
	@Override
	public JpaRepository<Estudiante, String> getDAO() {
		// TODO Auto-generated method stub
		return estudianteDAO;
	}

	@Override
	public Page<Estudiante> buscar(String dni, Pageable pageable) {
		// TODO Auto-generated method stub
		return estudianteDAO.findBydni(dni,pageable);
	}






}
