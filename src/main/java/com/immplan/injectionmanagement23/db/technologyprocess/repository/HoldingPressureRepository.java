package com.immplan.injectionmanagement23.db.technologyprocess.repository;

import com.immplan.injectionmanagement23.db.technologyprocess.PressureExposure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldingPressureRepository extends JpaRepository<PressureExposure, Long> {
}
