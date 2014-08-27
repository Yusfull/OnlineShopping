package com.ehealth.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import scala.annotation.cloneable;

import com.ehealth.infrustructure.SecurityConfig;
import com.ehealth.infrustructure.security.SecurityService;
import com.ehealth.service.PersonService;

public class UserDetailServiceTest {

	static ApplicationContext applicationContext = null;
	static SecurityService securityService = null;
	
	@BeforeClass
	public static void setup(){
		applicationContext = new AnnotationConfigApplicationContext(SecurityConfig.class);
		securityService = applicationContext.getBean(SecurityService.class);
	}
	
	/**
     * Test the valid user with valid role
     * */
    @Test
    public void testValidRole()
    {
        //Get the user by username from configured user details service
        UserDetails userDetails = securityService.loadUserByUsername ("soffoalbert");
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        PersonService service = (PersonService) applicationContext.getBean(PersonService.class);
        service.findByEmail("soffo@gmail.com");
    }
    
    /**
     * Test the valid user with INVALID role
     * */
    @Test (expected = AccessDeniedException.class)
    public void testInvalidRole()
    {
        UserDetails userDetails = securityService.loadUserByUsername ("soffoalbert");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_INVALID"));
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(),authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        PersonService service = (PersonService) applicationContext.getBean(PersonService.class);
        service.findByEmail("soffo@gmail.com");
    }
    
    /**
     * Test the INVALID user 
     * */
    @Test (expected = AccessDeniedException.class)
    public void testInvalidUser()
    {
        UserDetails userDetails = securityService.loadUserByUsername ("soffo");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_INVALID"));
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        PersonService service = (PersonService) applicationContext.getBean(PersonService.class);
        service.findByEmail("soffo@gmail.com");
    }
     
}
