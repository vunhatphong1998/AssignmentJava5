package edu.poly.spt.services;

import java.util.Optional;

import edu.poly.spt.models.login;

public interface loginService {
 
	boolean checklogin(String username, String pass);
	
	Optional<login> findUserById(String id);
}
