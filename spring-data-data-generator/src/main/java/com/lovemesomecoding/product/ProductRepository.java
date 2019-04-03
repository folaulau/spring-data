package com.lovemesomecoding.product;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Set<Product> findByIdIn(List<Long> ids);
}
