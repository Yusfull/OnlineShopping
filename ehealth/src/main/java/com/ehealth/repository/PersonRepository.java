package com.ehealth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ehealth.domain.Person;

/**
 * @author Georges Soffo
 */

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

    public Person findByUsername(String username);

    public Person findByEmail(String email);
}
