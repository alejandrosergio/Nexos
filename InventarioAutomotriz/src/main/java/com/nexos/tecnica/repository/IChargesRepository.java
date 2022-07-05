package com.nexos.tecnica.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexos.tecnica.models.Charges;

/**
 * @author SergioHernandez
 *
 */
@Repository
public interface IChargesRepository extends JpaRepository<Charges, Long> {
	
	
	Optional<List<Charges>> findByCharge(String charge);
	
	Optional<List<Charges>> findByCreationOn(Date creationOn);
	
}