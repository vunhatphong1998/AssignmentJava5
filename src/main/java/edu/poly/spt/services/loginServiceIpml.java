package edu.poly.spt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spt.models.login;
import edu.poly.spt.repositories.loginRepository;

@Service
public class loginServiceIpml implements loginService  {
	@Autowired 
	private loginRepository loginRepository;
	
	
	@Override
    public boolean checklogin(String username, String pass) {
        Optional<login> optionalTaiKhoan = findUserById(username);
        if (optionalTaiKhoan.isPresent() && optionalTaiKhoan.get().getPass().equals(pass)) {
            return true;
        }
        return false;
    }

	
	@Override
    public Optional<login> findUserById(String username) {
        return loginRepository.findById(username);
    }
	

	
}
