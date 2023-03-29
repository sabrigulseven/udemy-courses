package com.sabrigulseven.houseapi.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sabrigulseven.houseapi.data.entity.House;

public interface HouseRepository extends JpaRepository<House, Long> {
	
	 @Query("SELECT e FROM House e WHERE "
	            + "e.propertyName LIKE %:input% OR "
	            + "e.houseType LIKE %:input% OR "
	            + "e.location LIKE %:input% OR "
	            + "e.cityCountry LIKE %:input% OR "
	            + "e.postalCode LIKE %:input%")
	Page<House> searchByUnclearField(@Param("input") String input, Pageable pageable);
	
	Page<House> findAll(Pageable pageable);

}
