package edu.poly.spt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spt.models.Depart;
import edu.poly.spt.models.Staff;
import edu.poly.spt.repositories.DepartRepository;
import edu.poly.spt.repositories.StaffRepository;

@Service
public class StaffServiceIpml implements StaffService {
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private DepartRepository departRepository;

	@Override
	public List<Depart> findAllDeparts(){
		return (List<Depart>) departRepository.findAll();
	}
	
	@Override
	public Staff save(Staff entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staff> saveAll(Iterable<Staff> entities) {
		return (List<Staff>)staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staff> findById(Integer id) {
		return staffRepository.findById(id);
	}
	
	@Override
	public boolean existsById(Integer id) {
		return staffRepository.existsById(id);
	}

	@Override
	public Iterable<Staff> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public Iterable<Staff> findAllById(Iterable<Integer> ids) {
		return staffRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staff entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staff> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}
	
	public List<Staff> findByNameLikeOrderByName(String name) {
		
		return staffRepository.findByNameLikeOrderByName("%" + name + "%");
	}

	


	
	
}
