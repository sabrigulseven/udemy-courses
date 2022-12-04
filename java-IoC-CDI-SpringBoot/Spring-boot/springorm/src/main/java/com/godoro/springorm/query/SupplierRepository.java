package com.godoro.springorm.query;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SupplierRepository extends CrudRepository<Supplier, Long>, CustomRepository {

	@Query("select s from Supplier s where s.supplierName= :supplierName")
	List<Supplier> findSuppliersByName(@Param("supplierName") String supplierName);
}
