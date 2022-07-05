package com.nexos.tecnica.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nexos.tecnica.repository.ICommodityRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CommodityTest {
	
	@Autowired
	private ICommodityRepository iCommodityRepository;

	
	@Test
	@Rollback(false)
	public void testSaveCommodity() {
		Commodity commodity = new Commodity("Productoz", 45, new Date(), "Alejandro", "Alejandro", new Date());
		Commodity CommoditySave =iCommodityRepository.save(commodity);
		
		assertNotNull(CommoditySave);
	}
	
	
	@Test
	@Rollback(false)
	public void testUpdateCommodity() {
		Commodity commodity = new Commodity(1L, "ProdctUPDz", 99, new Date(), "AlejandroUPD","AlejandroUPD", new Date(), "Alejandro", new Date());
		Commodity CommodityUpd =iCommodityRepository.save(commodity);
		
		assertNotNull(CommodityUpd);
	}
	
	
	@Test
	@Rollback(false)
	public void testFindById() {
		Commodity commodityID = new Commodity(1L);
		iCommodityRepository.findById(commodityID.getID());
		
		assertThat(commodityID.getID()).isEqualTo(1);
	}
	
	
	@Test
	@Rollback(false)
	public void testFindByProduct() {
		Commodity commodityProduct = new Commodity("Productoz");
		iCommodityRepository.findByProduct(commodityProduct.getProduct());
		
		assertThat(commodityProduct.getProduct()).isEqualTo("Productoz");
	}
	
	
	@Test
	@Rollback(false)
	public void testFindByCreationOn() {
		List<Commodity>  Commoditys = iCommodityRepository.findAll();
		assertNotNull(Commoditys);
		
	}
	
	
	@Test
	@Rollback(false)
	public void testGetAll() {
		Commodity commodityCreationOn = new Commodity(new Date());
		iCommodityRepository.findByCreationOn(commodityCreationOn.getCreationOn());
		
		assertNotNull(commodityCreationOn.getCreationOn());
		
	}
	
	
	@Test
	@Rollback(false)
	public void testDeleteCommodity() {
		Commodity commodityID = new Commodity(5L);
		iCommodityRepository.deleteById(commodityID.getID());
		
		assertNotNull(commodityID);
	}

}