package com.immplan.injectionmanagement23.db.rawmaterial.repository;

import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.rawmaterial.MasterBatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterBatchRepository extends JpaRepository<MasterBatch, Long> {
    MasterBatch findMasterBatchByMaterialId(Long id);
    List<MasterBatch> getMasterBatchByMaterialActiveOrderByMaterialName(boolean materialActive);
    List<MasterBatch> getMasterBatchByMaterialActiveAndProducerOrderByMaterialName(boolean materialActive, Producer producer);
}
