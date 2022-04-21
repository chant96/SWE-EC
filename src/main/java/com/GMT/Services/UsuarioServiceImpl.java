package com.GMT.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GMT.Entidad.Usuario;
import com.GMT.Persistencia.IUsuarioDAO;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioDAO.findByemail(email);
	    List grantList = new ArrayList();
	    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getAutorizacion());
	    grantList.add(grantedAuthority);
			
	    return new User(usuario.getUsuario(), usuario.getContraseña(), grantList);
	}

}
