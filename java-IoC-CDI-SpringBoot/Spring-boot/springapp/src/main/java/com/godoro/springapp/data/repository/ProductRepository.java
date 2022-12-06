package com.godoro.springapp.data.repository;

import com.godoro.springapp.data.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
