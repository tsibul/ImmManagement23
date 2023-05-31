package com.immplan.injectionmanagement23.db.product.product.repository;

import com.immplan.injectionmanagement23.db.product.product.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
    List<ProductGroup> findProductGroupsByProductGroupActiveOrderByProductGroupName(boolean active);
    List<ProductGroup> findProductGroupsByProductGroupActiveAndColorGroupColorGroupIdOrderByProductGroupName(boolean active, Long colorGroup);
    ProductGroup findProductGroupsByProductGroupId(Long productGroupId);
}
