package com.immplan.injectionmanagement23.db.producer.repository;

import com.immplan.injectionmanagement23.db.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
