package com.immplan.injectionmanagement23.db.product.color.repository;

import com.immplan.injectionmanagement23.db.product.color.ProductColorDoze;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductColorDozeRepository extends JpaRepository<ProductColorDoze, Long> {
    ProductColorDoze findProductColorDozeByProductColorDozeId(Long productColorDozeId);
    List<ProductColorDoze> findProductColorDozeByProductColorDozeActiveOrderByColorColorCode
            (boolean productColorDozeActive);
    List<ProductColorDoze> findProductColorDozeByProductColorDozeActiveAndColorColorIdOrderByColorColorCode
            (boolean productColorDozeActive, Long colorId);
}
