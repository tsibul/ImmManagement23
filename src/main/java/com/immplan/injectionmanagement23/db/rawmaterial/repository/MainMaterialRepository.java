package com.immplan.injectionmanagement23.db.rawmaterial.repository;

import com.immplan.injectionmanagement23.db.rawmaterial.MainMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainMaterialRepository extends JpaRepository<MainMaterial, Long> {
    MainMaterial findMainMaterialByMaterialId(Long materialId);
    List<MainMaterial> findMainMaterialByMaterialActiveOrderByMaterialName(boolean mainMaterialActive);
    List<MainMaterial> findMainMaterialByMaterialActiveAndMaterialTypeMaterialIdOrderByMaterialName
            (boolean mainMaterialActive, Long materialTypeId);
    List<MainMaterial> findMainMaterialByMaterialActiveAndProducerIdOrderByMaterialName
            (boolean mainMaterialActive, Long producerId);
    List<MainMaterial> findMainMaterialByMaterialActiveAndProducerIdAndMaterialTypeMaterialIdOrderByMaterialName
            (boolean mainMaterialActive, Long producerId, Long materialTypeId);

}
