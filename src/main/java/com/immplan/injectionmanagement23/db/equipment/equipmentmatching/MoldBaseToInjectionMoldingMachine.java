package com.immplan.injectionmanagement23.db.equipment.equipmentmatching;

import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "moldbase_to_injectionmoldingmachine")
public class MoldBaseToInjectionMoldingMachine {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(targetEntity = MoldBase.class)
    @JoinColumn(name = "mold_base", referencedColumnName = "equipment_id", nullable = false)
    private MoldBase moldBase;
    @ManyToOne(targetEntity = InjectionMoldingMachine.class)
    @JoinColumn(name = "injection_molding_machine", referencedColumnName = "equipment_id", nullable = false)
    private InjectionMoldingMachine injectionMoldingMachine;
    @Column(name = "mold_base_imm_active", columnDefinition = "boolean default true", nullable = false)
    private boolean moldBaseToInjectionMoldingMachineActive = true;

    public boolean isMoldBaseToInjectionMoldingMachineActive() {
        return moldBaseToInjectionMoldingMachineActive;
    }

    public void setMoldBaseToInjectionMoldingMachineActive(boolean moldBaseToInjectionMoldingMachineActive) {
        this.moldBaseToInjectionMoldingMachineActive = moldBaseToInjectionMoldingMachineActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoldBase getMoldBase() {
        return moldBase;
    }

    public void setMoldBase(MoldBase moldBase) {
        this.moldBase = moldBase;
    }

    public InjectionMoldingMachine getInjectionMoldingMachine() {
        return injectionMoldingMachine;
    }

    public void setInjectionMoldingMachine(InjectionMoldingMachine injectionMoldingMachine) {
        this.injectionMoldingMachine = injectionMoldingMachine;
    }
    public Long getInjectionMoldingMachineEquipmentId(){
        return this.injectionMoldingMachine.getEquipmentId();
    }

}
