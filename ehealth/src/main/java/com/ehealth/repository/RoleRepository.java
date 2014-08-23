
package com.ehealth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ehealth.domain.Role;


/**
 * @author Georges Soffo
 */
public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {
	
	Role findByName(String name);
}
