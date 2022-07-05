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

import com.nexos.tecnica.models.Users;
import com.nexos.tecnica.services.UsersService;

/**
 * @author SergioHernandez
 *
 */
@RestController
@RequestMapping("User")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@GetMapping
	public ResponseEntity<Page<Users>> getAllUsers(
			@RequestParam(required = false, defaultValue = "0")Integer page,
			@RequestParam(required = false, defaultValue = "10")Integer size, 
			@RequestParam(required = false, defaultValue = "false")Boolean enablePagination) 
	{
		return ResponseEntity.ok().body(usersService.getAllUsers(page, size, enablePagination));
	}
	
	
	@GetMapping( value = "ID/{ID}")
	public ResponseEntity<Users> findByUserId(@PathVariable("ID") Long ID) {
		
		Optional<Users> optional = usersService.findByUserId(ID);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optional.get());
	}
	

	@GetMapping( value = "/Name/{Name}")
	public ResponseEntity<List<Users>> findByCharge(@PathVariable("Name") String name) {
		
		Optional<List<Users>> optional = usersService.findByName(name);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
	@GetMapping( value = "/CreationOn/{CreationOn}")
	public ResponseEntity<List<Users>> findByCharge(@PathVariable("CreationOn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date creationOn) {
		
		Optional<List<Users>> optional = usersService.findByCreationOn(creationOn);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	
	
	@PostMapping
	public ResponseEntity<Users> saveUsers(@RequestBody Users User) {
		
		Users UserBD = usersService.saveUsers(User);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(UserBD);
	}
	
	
	
	@PutMapping( value = "/{ID}")
	public ResponseEntity<Users> editUsers(@RequestBody Users User, @PathVariable("ID") Long ID) {
		
		Optional<Users> optional = usersService.findByUserId(ID);
		
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Users UsersDB = optional.get();
		UsersDB.setName(User.getName());
		UsersDB.setAge(User.getAge());
		UsersDB.setCharge(User.getCharge());
		UsersDB.setAdmissionDate(User.getAdmissionDate());
		UsersDB.setCreatedBy(User.getCreatedBy());
		UsersDB.setCreationOn(User.getCreationOn());
		UsersDB.setModifiedBy(User.getModifiedBy());
		UsersDB.setModifiedOn(User.getModifiedOn());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.editUsers(UsersDB));
	}
	
	
	@DeleteMapping( value = "/{ID}")
	public ResponseEntity<Optional<Users>> deleteUsers(@PathVariable("ID") Long ID) {
		usersService.deleteUsers(ID);
		return ResponseEntity.noContent().build();
	}
	

}




