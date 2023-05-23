package com.immplan.injectionmanagement23.db.producer.repository;

import com.immplan.injectionmanagement23.db.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
    List<Producer> findProducerByProducerActiveOrderByProducerName(boolean producerActive);
    List<Producer> findProducerByProducerActiveAndCountryIdOrderByProducerName(boolean producerActive, long countryId);
    List<Producer> findProducerByProducerActiveAndProducerTypeProducerTypeIdOrderByProducerName(boolean producerActive,
                                                                                                long producerTypeId);
    List<Producer> findProducerByProducerActiveAndCountryIdAndProducerTypeProducerTypeIdOrderByProducerName(
            boolean producerActive, long countryId, long producerTypeId);
    Producer findProducerById(Long id);
}
