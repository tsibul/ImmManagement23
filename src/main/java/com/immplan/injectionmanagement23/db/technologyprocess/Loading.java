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

    @Column(name = "position", length = 5, nullable = false)
    private double position = 55.5;

    @Column(name = "loadingPressure", length = 5, nullable = false)
    private double loadingPressure;

    @Column(name = "loadingSpeed", length = 3, nullable = false)
    private int loadingSpeed;

    @Column(name = "backPressure", length = 2, nullable = false)
    private int backPressure;

    @Column(name = "decompression", length = 2, nullable = false)
    private int decompression;
}
