package hu.unideb.hospitalnet.core.dao;

import hu.unideb.hospitalnet.core.entity.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface PatientDao extends JpaRepository<Patient, Long>  {

	Page<Patient>findByNameStartsWith(String filter,Pageable pageable);
	
	Page<Patient>findBySsnStartsWith(String filter,Pageable pageable);
		
	Page<Patient>findByIdNumberStartsWith(String filter,Pageable pageable);
	
	Page<Patient>findByDateOfBirthContaining(String filter,Pageable pageable);
	
	
	Page<Patient>findByStatusStartsWith(String filter,Pageable pageable);

}
