package hu.unideb.hospitalnet.core.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.hospitalnet.core.entity.Product;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface ProductDao extends JpaRepository<Product, Long> {

	Product findByName(String name);
	
	Page<Product> findByNameContaining(String name, Pageable pageable);
}
