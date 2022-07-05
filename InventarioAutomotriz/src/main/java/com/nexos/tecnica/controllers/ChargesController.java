package com.nexos.tecnica.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.tecnica.models.Charges;
import com.nexos.tecnica.services.ChargesService;

/**
 * @author SergioHernandez
 *
 */
@RestController
@RequestMapping("Charge")
public class ChargesController {
	
	@Autowired
	private ChargesService chargesService;
	
	
	@GetMapping
	public ResponseEntity<Page<Charges>> getAllCharges(
			@RequestParam(required = false, defaultValue = "0")Integer page,
			@RequestParam(required = false, defaultValue = "10")Integer size, 
			@RequestParam(required = false, defaultValue = "false")Boolean enablePagination) 
	{
		return ResponseEntity.ok().body(chargesService.getAllCharges(page, size, enablePagination));
	}
	
	
	@GetMapping( value = "/ID/{ID}")
	public ResponseEntity<Charges> findByChargeId(@PathVariable("ID") Long ID) {
		
		Optional<Charges> optional = chargesService.findByChargeId(ID);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optional.get());
	}
	
	@GetMapping( value = "/Charge/{Charge}")
	public ResponseEntity<List<Charges>> findByCharge(@PathVariable("Charge") String charge) {
		
		Optional<List<Charges>> optional = chargesService.findByCharge(charge);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@GetMapping( value = "/CreationOn/{CreationOn}")
	public ResponseEntity<List<Charges>> findByCharge(@PathVariable("CreationOn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date creationOn) {
		
		Optional<List<Charges>> optional = chargesService.findByCreationOn(creationOn);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
	@PostMapping
	public ResponseEntity<Charges> saveCharges(@RequestBody Charges charge) {
		
		Charges chargeBD = chargesService.saveCharges(charge);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(chargeBD);
	}
	
	
	
	@PutMapping( value = "/{ID}")
	public ResponseEntity<Charges> editCharges(@RequestBody Charges charge, @PathVariable("ID") Long ID) {
		
		Optional<Charges> optional = chargesService.findByChargeId(ID);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Charges chargesDB = optional.get();
		chargesDB.setCharge(charge.getCharge());
		chargesDB.setCreatedBy(charge.getCreatedBy());
		chargesDB.setCreationOn(charge.getCreationOn());
		chargesDB.setModifiedBy(charge.getModifiedBy());
		chargesDB.setModifiedOn(charge.getModifiedOn());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(chargesService.editCharges(chargesDB));
	}
	
	
	@DeleteMapping( value = "/{ID}")
	public ResponseEntity<Optional<Charges>> deleteCharges(@PathVariable("ID") Long ID) {
		chargesService.deleteCharges(ID);
		return ResponseEntity.noContent().build();
	}
	

}




