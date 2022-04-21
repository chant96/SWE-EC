package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Pago;
import com.GMT.Persistencia.IPagoDAO;

@Service
public class PagoServiceImpl extends GenericServiceImpl<Pago, Integer> implements IPagoService{

	@Autowired
	private IPagoDAO pagoDAO;

	@Override
	public JpaRepository<Pago, Integer> getDAO() {
		// TODO Auto-generated method stub
		return pagoDAO;
	}

}
