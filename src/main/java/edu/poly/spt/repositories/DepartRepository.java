package edu.poly.spt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spt.models.Depart;

@Repository
public interface DepartRepository extends CrudRepository<Depart, Integer> {
   public List<Depart> findByNameLikeOrderByName(String name);
	

}
