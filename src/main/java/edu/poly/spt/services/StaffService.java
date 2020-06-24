package edu.poly.spt.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spt.models.Depart;
import edu.poly.spt.models.Staff;

public interface StaffService {

	void deleteAll();

	void deleteAll(List<Staff> entities);

	void delete(Staff entity);

	void deleteById(Integer id);

	long count();

	Iterable<Staff> findAllById(Iterable<Integer> ids);

	Iterable<Staff> findAll();

	boolean existsById(Integer id);

	Optional<Staff> findById(Integer id);

	List<Staff> saveAll(Iterable<Staff> entities);
	
	List<Staff> findByNameLikeOrderByName(String name);

	Staff save(Staff entity);

	List<Depart> findAllDeparts();

	

}
