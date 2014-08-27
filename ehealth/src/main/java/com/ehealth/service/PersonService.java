package com.ehealth.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ehealth.domain.Person;
	
	public interface PersonService {

	    //public List<Person> findAll();

	    public void persist(Person person);

	    public void merge(Person person);

	    public Person findById(String id);

	    public void delete(Person person);

	    public Person findByUsername(String username);
	    
	    public Person findByEmail(String username);

	}

