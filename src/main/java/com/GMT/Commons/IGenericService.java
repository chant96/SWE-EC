package com.GMT.Commons;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenericService <T,ID extends Serializable>{
	
	T guardar(T entity);
	void eliminar(T entity);
	T buscar(ID id);
	List<T> listar();
	Page<T>paginado(Pageable pageable);
	
}
