package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Curso;
import com.GMT.Persistencia.ICursoDAO;
import com.GMT.Persistencia.IHorarioDAO;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Integer> implements ICursoService{

	@Autowired
	private ICursoDAO cursoDAO;
	@Autowired
	private IHorarioDAO horarioDAO;
	

	@Override
	public void Insertar(Curso entity) {
		// TODO Auto-generated method stub
		horarioDAO.save(entity.getHorario());
		cursoDAO.save(entity);
	}


	@Override
	public JpaRepository<Curso, Integer> getDAO() {
		// TODO Auto-generated method stub
		return cursoDAO;
	}




}
