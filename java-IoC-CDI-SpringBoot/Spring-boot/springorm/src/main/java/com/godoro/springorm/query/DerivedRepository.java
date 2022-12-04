package com.godoro.springorm.query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DerivedRepository extends JpaRepository<Supplier, Long> {

	List<Supplier> findBySupplierName(String supplierName);

	List<Supplier> findBySupplierNameLike(String supplierNamePattern);

	List<Supplier> findBySupplierNameStartsWith(String supplierNameStart);
	
	List<Supplier> findBySupplierNameEndsWith(String supplierNameEnd);

	List<Supplier> findByTotalDebitGreaterThanEqual(double totalDebitMin);

	List<Supplier> findByTotalDebitBetween(double totalDebitMin, double totalDebitMax);

	List<Supplier> findBySupplierNameEndsWithOrTotalDebitLessThan(String supplierNameEnd, double totalDebitMax);

}
