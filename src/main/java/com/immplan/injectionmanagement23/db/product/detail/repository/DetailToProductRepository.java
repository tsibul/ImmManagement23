package com.immplan.injectionmanagement23.db.product.detail.repository;

import com.immplan.injectionmanagement23.db.product.detail.DetailToProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailToProductRepository extends JpaRepository<DetailToProduct, Long> {
    DetailToProduct findDetailToProductByDetailToProductId(Long detailToProductId);
    List<DetailToProduct> findDetailToProductsByDetailToProductActiveOrderByProductAscDetailIndexInProduct(boolean detailToProductActive);
    List<DetailToProduct> findDetailToProductsByDetailToProductActiveAndProductProductIdOrderByProductProductNameAscDetailIndexInProduct
            (boolean detailToProductActive, Long productId);
}
