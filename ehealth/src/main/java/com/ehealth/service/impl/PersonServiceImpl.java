package com.ehealth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealth.domain.Person;
import com.ehealth.repository.PersonRepository;
import com.ehealth.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findByEmail(String username) {
        return personRepository.findByEmail(username);
    }

    @Override
    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    /*@Override
    public List<Person> findAll() {
        return ImmutableList.copyOf(personRepository.findAll());
    }*/

    @Override
    public void persist(Person person) {

        personRepository.save(person);

    }

    @Override
    public void merge(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findById(String id) {
        return personRepository.findOne(id);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
