package edu.poly.spt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import edu.poly.spt.models.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> { 
	 public List<Staff> findByNameLikeOrderByName(String name);
	
}
