package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "loading")
public class Loading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loading_id")
    private Long loadingId;

    public Long getLoadingId() {
        return loadingId;
    }
}
