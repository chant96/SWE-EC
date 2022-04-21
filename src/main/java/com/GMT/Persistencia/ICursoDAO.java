package com.GMT.Persistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Curso;


@Repository
public interface ICursoDAO extends JpaRepository<Curso,Integer>{

}
