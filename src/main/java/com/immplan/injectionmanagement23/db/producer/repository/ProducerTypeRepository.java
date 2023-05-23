package com.immplan.injectionmanagement23.db.producer.repository;

import com.immplan.injectionmanagement23.db.producer.ProducerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProducerTypeRepository extends JpaRepository <ProducerType, Long> {
    List<ProducerType> findProducerTypeByProducerTypeActiveOrderByProducerTypeName(boolean producerTypeActive);
    ProducerType findProducerTypeByProducerTypeId(Long producerTypeId);
}
