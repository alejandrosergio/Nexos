package com.nexos.tecnica.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexos.tecnica.models.Users;

/**
 * @author SergioHernandez
 *
 */
@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
	
	Optional<List<Users>> findByName(String charge);
	
	Optional<List<Users>> findByCreationOn(Date creationOn);

}