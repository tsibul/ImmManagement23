package com.immplan.injectionmanagement23.db.jobsteps;

import jakarta.persistence.*;

@Entity
@Table(name = "job_steps")
public class JobSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_steps_id")
    private Long jobStepsId;

    public Long getJobStepsId() {
        return jobStepsId;
    }
}
