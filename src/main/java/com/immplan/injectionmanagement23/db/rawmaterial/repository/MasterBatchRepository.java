package com.immplan.injectionmanagement23.db.rawmaterial.repository;

import com.immplan.injectionmanagement23.db.rawmaterial.MasterBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterBatchRepository extends JpaRepository<MasterBatch, Long> {
}
