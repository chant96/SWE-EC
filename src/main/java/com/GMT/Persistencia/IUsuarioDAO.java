package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GMT.Entidad.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario,Integer>{
	
	 public Usuario findByusuario(String usuario);
	 public Usuario findByemail(String email);
}
