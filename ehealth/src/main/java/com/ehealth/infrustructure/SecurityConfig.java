package com.ehealth.infrustructure;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@ComponentScan
@PropertySource("classpath:application.properties")
//@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	InfrustructureConfig infrustructureConfig;

	@Autowired
	private SecurityService userDetailsService;

	@Autowired
	private Md5PasswordEncoder passwordEncoder(){
		Md5PasswordEncoder s = new Md5PasswordEncoder();
		return s;
	}
	@Resource
	private Environment env;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	@Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	
	@Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }


	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeUrls().antMatchers("/api/**").hasRole("ADMIN").and().httpBasic();
	        http.authorizeUrls().antMatchers("/", "/index", "/user/**", "/about").permitAll()
	            .antMatchers("/admin/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
	            .and().formLogin()
	            .loginUrl("/login")
	            .failureUrl("/login-error")
	            .loginProcessingUrl("/security_check")
	            .usernameParameter("j_username").passwordParameter("j_password")
	            .permitAll();

	        http.logout().logoutUrl("/logout");
	       
	    }

}
