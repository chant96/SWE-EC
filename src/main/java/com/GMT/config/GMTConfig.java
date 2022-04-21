package com.GMT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.GMT.Services.UsuarioServiceImpl;


@EnableWebSecurity 
@Configuration
public class GMTConfig extends WebSecurityConfigurerAdapter{

	  String[] resources = new String[]{
	            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**",
	            "/fonts/**","/vendors/**","/scss/**","/images/**","/Reportes/**",
	            "/webjars/**"
	    };
	  
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        	http
	        	.csrf().disable()
	            .authorizeRequests()
		        .antMatchers(resources).permitAll()  
		        .antMatchers("/","/login").permitAll()
		        /*.antMatchers("/InformacionCuenta","/ServicioMecanico/Informacion**","/Home","/ServicioMecanico/listar","/ServicioMecanico/Gestionar",
		        		"/ServicioMecanico/listarPersonal","/ServicioMecanico/listarClientes",
		        		"/ServicioMecanico/Guardar","/ServicioMecanico/agregarDetalleServicio",
		        		"/ServicioMecanico/listarDetalles").access("hasRole('USER') or hasRole('ADMIN')")
		        .antMatchers("/**").access("hasRole('ADMIN')")*/
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .defaultSuccessUrl("/Home",true)
	                .failureUrl("/login?error=true")
	                .usernameParameter("email")
	                .passwordParameter("password")
	                .and()
	            .logout()
	                .permitAll()
	                .logoutSuccessUrl("/login?logout");
	    }
	  
	  BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
			bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	        return bCryptPasswordEncoder;
	    }
		
	    @Autowired
	    UsuarioServiceImpl userDetailsService;
		
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception { 
	    	
	        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
	    }
	    
	    
}
