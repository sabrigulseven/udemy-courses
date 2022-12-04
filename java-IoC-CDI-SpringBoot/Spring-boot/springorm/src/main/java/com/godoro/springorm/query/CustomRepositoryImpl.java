package com.godoro.springorm.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Supplier> findSupplierTotalDebitMin(double totalDebitMin) {
		String jpql = "Select s from Supplier s Where s.totalDebit >= : totalDebitMin";
		TypedQuery<Supplier> query = entityManager.createQuery(jpql, Supplier.class);
		query.setParameter("totalDebitMin", totalDebitMin);
		List<Supplier> supplierList = query.getResultList();
		return supplierList;
	}
}
