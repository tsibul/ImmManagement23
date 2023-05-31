package com.immplan.injectionmanagement23.db.product.product.repository;

import com.immplan.injectionmanagement23.db.product.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByProductActiveOrderByProductCode(boolean productActive);
    List<Product>
    findProductByProductActiveAndProductGroupProductGroupIdOrderByProductCode(boolean productActive, Long productGroupId);
    Product findProductByProductId(long productId);
    Product findProductByProductCode(String productCode);
}
