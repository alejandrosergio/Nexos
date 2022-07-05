package com.nexos.tecnica.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nexos.tecnica.models.Charges;
import com.nexos.tecnica.repository.IChargesRepository;

/**
 * @author SergioHernandez
 *
 */
@Service
public class ChargesService {
	
	@Autowired
	private IChargesRepository iChargesRepository;
	
	
	public Page<Charges> getAllCharges(Integer page, Integer size, Boolean enablePagination) {
		return iChargesRepository.findAll( enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
	}
	
	public Optional<Charges> findByChargeId(Long ID){
		return iChargesRepository.findById(ID);
	}
	
	public Optional<List<Charges>> findByCharge(String charge){
		return iChargesRepository.findByCharge(charge);
	}
	
	public Optional<List<Charges>> findByCreationOn(Date creationOn){
		return iChargesRepository.findByCreationOn(creationOn);
	}
	
	
	public Charges saveCharges(Charges charge) {
		
		if( charge.getID() == null) {
			return iChargesRepository.save(charge);
		}
		
		return null;
	}
	
	
	public Charges editCharges(Charges charge) {
		
		if( charge.getID() != null && iChargesRepository.existsById(charge.getID())) {
			return iChargesRepository.save(charge);
		}
		
		return null;
		
	}
	
	
	public void deleteCharges(Long ID) {
		iChargesRepository.deleteById(ID);
	}
	
	
	public boolean existById(Long ID) {
		return iChargesRepository.existsById(ID);
	}
	

}




