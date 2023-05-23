package com.immplan.injectionmanagement23.db.producer.repository;

import com.immplan.injectionmanagement23.db.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
    List<Producer> findProducerByProducerActiveOrderByProducerName(boolean producerActive);
    Producer findProducerById(Long id);
}
