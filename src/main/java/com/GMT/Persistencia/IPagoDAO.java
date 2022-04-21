package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Pago;

@Repository
public interface IPagoDAO extends JpaRepository<Pago,Integer>{

}
