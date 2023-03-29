package com.sabrigulseven.houseapi.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sabrigulseven.houseapi.data.entity.House;
import com.sabrigulseven.houseapi.data.repository.HouseRepository;
import com.sabrigulseven.houseapi.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseRepository houseRepository;

	public Page<House> getAllHouses(Pageable pageable) {
		return houseRepository.findAll(pageable);
	}

	public House saveHouse(House house) {
		return houseRepository.save(house);
	}

	public House updateHouse(long id, House updatedHouse) {
		Optional<House> optionalHouse = houseRepository.findById(id);
		if (optionalHouse.isPresent()) {
			House house = optionalHouse.get();
			BeanUtils.copyProperties(updatedHouse, house);
			return houseRepository.save(house);
		} else {
			return null;
		}
	}

	public void deleteHouse(long id) {
		houseRepository.deleteById(id);
	}

	public Page<House> searchHouses(String input, Pageable pageable) {
		return houseRepository.searchByUnclearField(input, pageable);
	}
}
