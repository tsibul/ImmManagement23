package com.immplan.injectionmanagement23.db.product.detail.repository;

import com.immplan.injectionmanagement23.db.product.detail.Detail;
import com.immplan.injectionmanagement23.db.product.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail getDetailByDetailId(Long detailId);
    List<Detail> findDetailByDetailActiveOrderByDetailCode(boolean detailActive);
    List<Detail> findDetailByDetailActiveAndDetailCodeOrderByIndexInProduct(boolean detailActive, Product detailCode);
    List<Detail> findDetailByDetailActiveAndMaterialTypeMaterialIdOrderByDetailCodeAscIndexInProduct(boolean detailActive, Long materialId);
    List<Detail> findDetailByDetailActiveAndMaterialTypeMaterialIdAndDetailCodeOrderByDetailCodeAscIndexInProduct
            (boolean detailActive, Long materialType_materialId, Product detailCode);
}
