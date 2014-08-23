package com.ehealth.infrustructure;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.ehealth.infrustructure.security.SecurityService;

@Configuration
@PropertySource("classpath:application.properties")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	InfrustructureConfig infrustructureConfig;

	@Autowired
	private SecurityService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder(){
		PasswordEncoder s = new BCryptPasswordEncoder();
		return s;
	}
	@Resource
	private Environment env;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth = new AuthenticationManagerBuilder();
		auth.userDetailsService(userDetailsService).passwordEncoder(
				passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeUrls().antMatchers("/users**", "/sessions/**")
				.hasRole("ADMIN").antMatchers("/resources/**", "/signup")
				.permitAll().anyRequest().hasRole("USER").and().formLogin()
				.loginPage("/login").permitAll();
	}

}
