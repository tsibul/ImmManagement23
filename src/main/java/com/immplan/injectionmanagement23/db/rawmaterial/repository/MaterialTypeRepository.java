package com.immplan.injectionmanagement23.db.rawmaterial.repository;

import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialTypeRepository extends JpaRepository<MaterialType, Long> {
    List<MaterialType> findMaterialTypeByMaterialActiveOrderByMaterialName(boolean materialActive);
    MaterialType findMaterialTypeByMaterialId(long materialId);
}
