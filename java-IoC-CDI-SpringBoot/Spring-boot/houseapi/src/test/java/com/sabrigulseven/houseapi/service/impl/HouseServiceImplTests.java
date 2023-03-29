package com.sabrigulseven.houseapi.service.impl;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sabrigulseven.houseapi.data.entity.House;
import com.sabrigulseven.houseapi.data.repository.HouseRepository;

@ExtendWith(MockitoExtension.class)
public class HouseServiceImplTests {

	@InjectMocks
	private HouseServiceImpl houseServiceImpl;
	
	@Mock
	private HouseRepository houseRepository;
	
	@Test
	public void testGetAllHouses() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveHouse() {
	    // Arrange
	    House house = new House();
	    house.setId(1L);
	    house.setPropertyName("My House");
	    house.setPrice(100000);
	    Mockito.when(houseRepository.save(any(House.class))).thenReturn(house);
	    
	    // Act
	    House savedHouse = houseServiceImpl.saveHouse(house);
	    
	    // Assert
	    Assertions.assertEquals(house.getId(), savedHouse.getId());
	    Assertions.assertEquals(house.getPropertyName(), savedHouse.getPropertyName());
	    Assertions.assertEquals(house.getPrice(), savedHouse.getPrice());
	}


	@Test
	public void testUpdateHouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteHouse() {
		fail("Not yet implemented");
	}

	@Test
	public 	void testSearchHouses() {
		fail("Not yet implemented");
	}

}
