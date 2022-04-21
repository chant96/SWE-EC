package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Horario;
import com.GMT.Persistencia.IHorarioDAO;

@Service
public class HorarioServiceImpl extends GenericServiceImpl<Horario, Integer> implements IHorarioService{

	@Autowired
	private IHorarioDAO horarioDAO;

	@Override
	public JpaRepository<Horario, Integer> getDAO() {
		// TODO Auto-generated method stub
		return horarioDAO;
	}
	
	


}
