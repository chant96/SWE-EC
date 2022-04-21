package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Maquina;

@Repository
public interface IMaquinaDAO extends JpaRepository<Maquina, Integer>{

}
