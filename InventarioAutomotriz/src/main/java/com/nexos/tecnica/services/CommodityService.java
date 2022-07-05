package com.nexos.tecnica.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nexos.tecnica.config.exception.BadRequestException;
import com.nexos.tecnica.models.Commodity;
import com.nexos.tecnica.repository.ICommodityRepository;

/**
 * @author SergioHernandez
 *
 */
@Service
public class CommodityService {
	
	@Autowired
	private ICommodityRepository iCommodityRepository;
	
	
	public Page<Commodity> getAllCommodity(Integer page, Integer size, Boolean enablePagination) {
		return iCommodityRepository.findAll( enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
	}
	
	
	public Optional<Commodity> findByCommodityId(Long ID){
		return iCommodityRepository.findById(ID);
	}
	
	
	public Optional<List<Commodity>> findByProduct(String product){
		return iCommodityRepository.findByProduct(product);
	}
	
	
	public Optional<List<Commodity>> findByCreationOn(Date creationOn){
		return iCommodityRepository.findByCreationOn(creationOn);
	}
	
	public boolean existsByProduct(String product){
		return iCommodityRepository.existsByProduct(product);
	}
	
	public String CommodityByID(Long ID){
		return iCommodityRepository.CommodityByID(ID);
	}
	
	public Commodity saveCommodity(Commodity Commodity) {
		
		if( Commodity.getProduct() == null || Commodity.getProduct().isEmpty() ) {
			throw new BadRequestException("El proucto no puede ir vacio."); 
		}
		
		if( Commodity.getQuantity() == null || Commodity.getQuantity() <= 0) {
			throw new BadRequestException("La cantidad debe ser mayor a uno."); 
		}
		
		if( Commodity.getAdmissionDate() == null || Commodity.getAdmissionDate().after(new Date()) ) {
			throw new BadRequestException("La fecha de ingreso debe ser menor o igual a la fecha actual."); 
		}
		
		if( iCommodityRepository.existsByProduct(Commodity.getProduct()) )  {
			throw new BadRequestException("El prducto se encuentra registrado."); 
		}
		
		return iCommodityRepository.save(Commodity);
	}
	
	
	public Commodity editCommodity(Commodity Commodity) {
		
		if( Commodity.getProduct() == null || Commodity.getProduct().isEmpty() ) {
			throw new BadRequestException("El proucto no puede ir vacio."); 
		}
		
		if( Commodity.getQuantity() == null || Commodity.getQuantity() <= 0) {
			throw new BadRequestException("La cantidad debe ser mayor a uno."); 
		}
		
		if( Commodity.getAdmissionDate() == null || Commodity.getAdmissionDate().after(new Date()) ) {
			throw new BadRequestException("La fecha de ingreso debe ser menor o igual a la fecha actual."); 
		}
		
		
		if( iCommodityRepository.existsByProduct(Commodity.getProduct()) )  {
			throw new BadRequestException("El prducto se encuentra registrado."); 
		}
		
		return iCommodityRepository.save(Commodity);
		
	}
	
	
	public void deleteCommodity(Long ID, String UserCreate) {
		
		String UserDelete = iCommodityRepository.CommodityByID(ID);
		
		if( !UserDelete.equals(UserCreate) )  {
			throw new BadRequestException("Solo puede eliminar este registro el usuario " + UserDelete);

		}
		
		iCommodityRepository.deleteById(ID);

	}
	
	
	public boolean existById(Long ID) {
		return iCommodityRepository.existsById(ID);
	}
	

}




