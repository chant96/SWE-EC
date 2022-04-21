package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Horario;

@Repository
public interface IHorarioDAO extends JpaRepository<Horario,Integer>{

}
