package com.nexos.tecnica.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.tecnica.models.Commodity;

/**
 * @author SergioHernandez
 *
 */
@Repository
public interface ICommodityRepository extends JpaRepository<Commodity, Long> {
	
	Optional<List<Commodity>> findByProduct(String product);
	
	Optional<List<Commodity>> findByCreationOn(Date creationOn);
	
	boolean existsByProduct(String product);
	
	@Query(value = "SELECT User_insert FROM Commodity WHERE ID=?1", nativeQuery=true)
    String CommodityByID(Long ID);
	
}