package com.GMT.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.GMT.Commons.IGenericService;
import com.GMT.Entidad.Instructor;

public interface IInstructorService extends IGenericService<Instructor, String>{

	public Instructor buscarDni(String dni);
	public Page<Instructor>  buscar(String dni,Pageable pageable);
}
