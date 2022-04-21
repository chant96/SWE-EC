package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Certificado;
import com.GMT.Persistencia.ICertificadoDAO;

@Service
public class CertificadoServiceImpl extends GenericServiceImpl<Certificado, Integer> implements ICertificadoService{

	@Autowired
	private ICertificadoDAO certificadoDAO;

	@Override
	public JpaRepository<Certificado, Integer> getDAO() {
		// TODO Auto-generated method stub
		return certificadoDAO;
	} 
	


}
