package com.sabrigulseven.houseapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sabrigulseven.houseapi.data.entity.House;

public interface HouseService {
	
	public Page<House> getAllHouses(Pageable pageable);

	public House saveHouse(House house);

	public House updateHouse(long id, House updatedHouse);

	public void deleteHouse(long id);

	public Page<House> searchHouses(String input, Pageable pageable);
}
