package com.immplan.injectionmanagement23.db.jobsteps.repository;

import com.immplan.injectionmanagement23.db.jobsteps.JobSteps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobStepsRepository extends JpaRepository<JobSteps, Long> {
}
