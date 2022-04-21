package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Certificado;

@Repository
public interface ICertificadoDAO extends JpaRepository<Certificado,Integer>{

}
