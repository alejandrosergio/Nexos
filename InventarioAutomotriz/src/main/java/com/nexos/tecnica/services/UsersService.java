package com.nexos.tecnica.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nexos.tecnica.models.Users;
import com.nexos.tecnica.repository.IUsersRepository;

/**
 * @author SergioHernandez
 *
 */
@Service
public class UsersService {
	
	@Autowired
	private IUsersRepository iUsersRepository;
	
	
	public Page<Users> getAllUsers(Integer page, Integer size, Boolean enablePagination) {
		return iUsersRepository.findAll( enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
	}
	
	public Optional<Users> findByUserId(Long ID){
		return iUsersRepository.findById(ID);
	}
	
	public Optional<List<Users>> findByName(String name){
		return iUsersRepository.findByName(name);
	}
	
	public Optional<List<Users>> findByCreationOn(Date creationOn){
		return iUsersRepository.findByCreationOn(creationOn);
	}

	
	public Users saveUsers(Users User) {
		
		if( User.getID() == null) {
			return iUsersRepository.save(User);
		}
		
		return null;
	}
	
	public Users editUsers(Users User) {
		
		if( User.getID() != null && iUsersRepository.existsById(User.getID())) {
			return iUsersRepository.save(User);
		}
		
		return null;
		
	}
	
	public void deleteUsers(Long ID) {
		iUsersRepository.deleteById(ID);
	}
	
	public boolean existById(Long ID) {
		return iUsersRepository.existsById(ID);
	}
	
}




