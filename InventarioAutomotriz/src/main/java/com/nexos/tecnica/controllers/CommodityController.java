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

import com.nexos.tecnica.models.Commodity;
import com.nexos.tecnica.services.CommodityService;

/**
 * @author SergioHernandez
 *
 */
@RestController
@RequestMapping("Commodity")
public class CommodityController {
	
	@Autowired
	private CommodityService commodityService;
	
	
	@GetMapping
	public ResponseEntity<Page<Commodity>> getAllCommodity(
			@RequestParam(required = false, defaultValue = "0")Integer page,
			@RequestParam(required = false, defaultValue = "10")Integer size, 
			@RequestParam(required = false, defaultValue = "false")Boolean enablePagination) 
	{
		return ResponseEntity.ok().body(commodityService.getAllCommodity(page, size, enablePagination));
	}
	
	
	@GetMapping( value = "ID/{ID}")
	public ResponseEntity<Commodity> findByCommodityId(@PathVariable("ID") Long ID) {
		
		Optional<Commodity> optional = commodityService.findByCommodityId(ID);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optional.get());
	}
	

	@GetMapping( value = "/Product/{Product}")
	public ResponseEntity<List<Commodity>> findByCharge(@PathVariable("Product") String product) {
		
		Optional<List<Commodity>> optional = commodityService.findByProduct(product);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
	@GetMapping( value = "/CreationOn/{CreationOn}")
	public ResponseEntity<List<Commodity>> findByCharge(@PathVariable("CreationOn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date creationOn) {
		
		Optional<List<Commodity>> optional = commodityService.findByCreationOn(creationOn);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
	
	@PostMapping
	public ResponseEntity<Commodity> saveCommodity(@RequestBody Commodity Commodity) {
		
		Commodity CommodityBD = commodityService.saveCommodity(Commodity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(CommodityBD);
	}
	
	
	
	@PutMapping( value = "/{ID}")
	public ResponseEntity<Commodity> editCommodity(@RequestBody Commodity Commodity, @PathVariable("ID") Long ID) {
		
		Optional<Commodity> optional = commodityService.findByCommodityId(ID);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Commodity CommodityDB = optional.get();
		CommodityDB.setProduct(Commodity.getProduct());
		CommodityDB.setQuantity(Commodity.getQuantity());
		CommodityDB.setUserInsert(Commodity.getUserInsert());
		CommodityDB.setAdmissionDate(Commodity.getAdmissionDate());
		CommodityDB.setCreatedBy(Commodity.getCreatedBy());
		CommodityDB.setCreationOn(Commodity.getCreationOn());
		CommodityDB.setModifiedBy(Commodity.getModifiedBy());
		CommodityDB.setModifiedOn(Commodity.getModifiedOn());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(commodityService.editCommodity(CommodityDB));
	}
	
	
	@DeleteMapping( value = "/{ID},{UserCreate}")
	public ResponseEntity<Optional<Commodity>> deleteCommodity(@PathVariable("ID") Long ID, @PathVariable("UserCreate") String UserCreate) {
		commodityService.deleteCommodity(ID,UserCreate);
		return ResponseEntity.noContent().build();
	}
	

}



