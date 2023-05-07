package com.immplan.injectionmanagement23.db.equipment.dryer.repository;

import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DryerRepository extends JpaRepository<Dryer, Long> {
}
