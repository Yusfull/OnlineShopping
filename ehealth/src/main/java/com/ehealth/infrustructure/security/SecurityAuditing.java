package com.ehealth.infrustructure.security;

import org.springframework.data.domain.AuditorAware;

import com.ehealth.domain.Person;

public class SecurityAuditing implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        Person person = new GetUserCredentials().getLoggedInUser();
        return person.getFirstname()+ "  " + person.getSurname()+ " with email " + person.getEmail();
    }
}
