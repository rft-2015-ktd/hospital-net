package hu.unideb.hospitalnet.core.dao;

import java.util.Date;
import java.util.List;

import hu.unideb.hospitalnet.core.entity.Operation;
import hu.unideb.hospitalnet.core.entity.Patient;
import hu.unideb.hospitalnet.core.entity.Worker;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface OperationDao extends JpaRepository<Operation, Long> {
	
	Page<Operation>findByWorkerUsername(String username,Pageable pageable);
	
	Page<Operation>findByWorker(Worker worker,Pageable pageable);
	
	List<Operation>findByWorker(Worker worke);
	
	List<Operation>findByWorkerAndFromDateGreaterThanEqual(Worker worke,Date date);
	

}
