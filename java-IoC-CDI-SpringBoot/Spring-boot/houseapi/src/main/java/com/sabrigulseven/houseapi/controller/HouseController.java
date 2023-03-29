package com.sabrigulseven.houseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sabrigulseven.houseapi.data.entity.House;
import com.sabrigulseven.houseapi.service.HouseService;

@RestController
public class HouseController {

	@Autowired
	private HouseService houseService;

	@GetMapping(value = "/list")
	public ResponseEntity<Page<House>> getAllHouses(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "50") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<House> housePage = houseService.getAllHouses(pageable);
		return ResponseEntity.ok(housePage);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<House> saveHouse(@RequestBody House house) {
		House savedHouse = houseService.saveHouse(house);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHouse);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<House> updateHouse(@PathVariable long id, @RequestBody House updatedHouse) {
		House house = houseService.updateHouse(id, updatedHouse);
		if (house == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(house);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteHouse(@PathVariable long id) {
		houseService.deleteHouse(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<Page<House>> searchHouses(@RequestParam("input") String input,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "50") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<House> housePage = houseService.searchHouses(input, pageable);
		return ResponseEntity.ok(housePage);
	}
}
