package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Maquina;
import com.GMT.Persistencia.IMaquinaDAO;

@Service
public class MaquinaServiceImpl extends GenericServiceImpl<Maquina, Integer> implements IMaquinaService{

	@Autowired
	private IMaquinaDAO maquinaDAO; 
	
	@Override
	public JpaRepository<Maquina, Integer> getDAO() {
		// TODO Auto-generated method stub
		return maquinaDAO;
	}

}
