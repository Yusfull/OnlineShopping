package com.ehealth.infrustructure;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.ehealth.infrustructure.security.SecurityService;
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableWebSecurity
@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	InfrustructureConfig infrustructureConfig;

	@Autowired
	private SecurityService userDetailsService;

	@Autowired
	private Md5PasswordEncoder passwordEncoder() {
		Md5PasswordEncoder s = new Md5PasswordEncoder();
		return s;
	}

	@Resource
	private Environment env;


	
    
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				passwordEncoder());
	}
	@Bean(name = "myAuthenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .permitAll();    
	}

}
