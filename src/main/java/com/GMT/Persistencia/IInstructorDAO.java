package com.GMT.Persistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Instructor;

@Repository
public interface IInstructorDAO extends JpaRepository<Instructor,String>{

	public Instructor findBydni(String dni);
	public Instructor deleteBydni(String dni);
	public Page<Instructor> findBydni(String dni, Pageable pageable);
}
