package hu.unideb.hospitalnet.core.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.hospitalnet.core.entity.Worker;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface WorkerDao extends JpaRepository<Worker, Long> {

	Worker findByUsername(String username);

	Page<Worker> findByNameContaining(String name, Pageable pageable);

	List<Worker> findByNameContaining(String query);

}
