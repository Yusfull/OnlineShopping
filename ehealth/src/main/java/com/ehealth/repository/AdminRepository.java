package com.ehealth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ehealth.domain.Admin;
/**
 * @author Georges Soffo
 */
public interface AdminRepository extends PagingAndSortingRepository<Admin, String>{
    
}


