package com.GMT.Services;

import com.GMT.Commons.IGenericService;
import com.GMT.Entidad.Curso;

public interface ICursoService extends IGenericService<Curso, Integer>{

	public void Insertar(Curso entity);
	
}
