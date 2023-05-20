package com.immplan.injectionmanagement23.db.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByProductActiveOrderByProductCode(boolean productActive);
    Product findProductByProductId(long productId);
}
