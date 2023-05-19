package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "injection")
public class Injection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "injection_id")
    private Long injectionId;

    public Long getInjectionId() {
        return injectionId;
    }

    @Column(name = "positionOne", length = 3, nullable = false)
    private double positionOne;
    @Column(name = "positionTwo", length = 3, nullable = false)
    private double positionTwo;
    @Column(name = "positionThree", length = 3, nullable = false)
    private double positionThree;
    @Column(name = "positionFour", length = 3, nullable = false)
    private double positionFour;

    @Column(name = "injectionPressure", length = 3, nullable = false)
    private double injectionPressure;

    @Column(name = "speedOne", length = 2, nullable = false)
    private double speedOne;

    @Column(name = "speedTwo", length = 2, nullable = false)
    private double speedTwo;

    @Column(name = "speedThree", length = 2, nullable = false)
    private double speedThree;

    @Column(name = "speedFour", length = 2, nullable = false)
    private double speedFour;

    @Column(name = "injectionTime", length = 3, nullable = false)
    private double injectionTime;

    @Column(name = "positionOfSwitch", length = 2, nullable = false)
    private int positionOfSwitch;
}
