package hu.unideb.hospitalnet.core.dao;

import java.util.List;

import hu.unideb.hospitalnet.core.entity.Bno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BnoDao extends JpaRepository<Bno, Long> {
	
	@Query("SELECT name FROM Bno")
	public List<String> findBnoName();

	public Page<Bno> findByNameContaining(String filter,Pageable pageable);

	public Page<Bno> findByKod10Containing(String filter,Pageable pageable);

}
