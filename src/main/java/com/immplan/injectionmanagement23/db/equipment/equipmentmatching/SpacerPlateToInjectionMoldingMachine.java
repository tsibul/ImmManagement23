package com.immplan.injectionmanagement23.db.equipment.equipmentmatching;

import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.SpacerPlate;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "spacerplate_to_injectionmoldingmachine")
public class SpacerPlateToInjectionMoldingMachine {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(targetEntity = SpacerPlate.class)
    @JoinColumn(name = "spacer_plate", referencedColumnName = "equipment_id", nullable = false)
    private SpacerPlate spacerPlate;
    @ManyToOne(targetEntity = InjectionMoldingMachine.class)
    @JoinColumn(name = "injection_molding_machine", referencedColumnName = "equipment_id", nullable = false)
    private InjectionMoldingMachine injectionMoldingMachine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpacerPlate getSpacerPlate() {
        return spacerPlate;
    }

    public void setSpacerPlate(SpacerPlate spacerPlate) {
        this.spacerPlate = spacerPlate;
    }

    public InjectionMoldingMachine getInjectionMoldingMachine() {
        return injectionMoldingMachine;
    }

    public void setInjectionMoldingMachine(InjectionMoldingMachine injectionMoldingMachine) {
        this.injectionMoldingMachine = injectionMoldingMachine;
    }
}
