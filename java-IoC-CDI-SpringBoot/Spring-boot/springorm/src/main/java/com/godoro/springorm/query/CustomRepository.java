package com.godoro.springorm.query;

import java.util.List;

public interface CustomRepository {
	public List<Supplier> findSupplierTotalDebitMin(double totalDebitMin);
}
