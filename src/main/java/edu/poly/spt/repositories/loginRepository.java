package edu.poly.spt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spt.models.login;

@Repository
public interface loginRepository extends CrudRepository<login, String> {
		
	
}
