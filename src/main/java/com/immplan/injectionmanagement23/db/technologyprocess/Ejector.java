package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "ejector")
public class Ejector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ejector_id")
    private Long ejectorId;

    public Long getEjectorId() {
        return ejectorId;
    }

    @Column(name = "connectionWithPlate", length = 50, nullable = false)
    private String connectionWithPlate = "Центральная жесткая сцепка";

    @Column(name = "pressure", length = 2, nullable = false)
    private int pressure = 80;

    @Column(name = "speed", length = 2, nullable = false)
    private int speed = 10;

    @Column(name = "delayEjectorForward", length = 1, nullable = false)
    private int delayEjectorForward = 0;

    @Column(name = "daelayEjectorBackward", length = 1, nullable = false)
    private int daelayEjectorBackward = 1;

    @Column(name = "countEjector", length = 1, nullable = false)
    private int countEjector = 1;

    @Column(name = "positionForward", length = 5, nullable = false)
    private double positionForward = 113.8;

    @Column(name = "positionBackward", length = 2, nullable = false)
    private int positionBackward = 3;
}
