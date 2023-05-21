package com.immplan.injectionmanagement23.db.product.product.repository;

import com.immplan.injectionmanagement23.db.product.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByProductActiveOrderByProductCode(boolean productActive);
    List<Product>
    findProductByProductActiveAndColorGroupColorGroupIdOrderByProductCode(boolean productActive, Long colorGroupId);
    List<Product>
    findProductByProductActiveAndAndProductGroupProductGroupIdOrderByProductCode(boolean productActive, Long productGroupId);
    List<Product>
    findProductByProductActiveAndColorGroupColorGroupIdAndProductGroupProductGroupIdOrderByProductCode(boolean productActive, Long colorGroupId, Long productGroupId);
    Product findProductByProductId(long productId);
}
