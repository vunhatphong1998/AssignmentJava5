package edu.poly.spt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.poly.spt.models.Depart;
import edu.poly.spt.repositories.DepartRepository;

public interface DepartService {
	

	void deleteAll();

	void deleteAll(List<Depart> entities);

	void delete(Depart entity);

	void deleteById(Integer id);

	long count();

	List<Depart> findAllById(List<Integer> ids);

	Iterable<Depart> findAll();

	boolean existsById(Integer id);
	
	List<Depart> findByNameLikeOrderByName(String name);

	Optional<Depart> findById(Integer id);

	List<Depart> saveAll(List<Depart> entities);

	Depart save(Depart entity);

	
}
