package com.immplan.injectionmanagement23.db.equipment.mold;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "mold_insert")
public class MoldInsert extends Equipment {
    public MoldInsert(){
        super();
        setEquipmentType("02.03");
        setEquipmentKind("02");
    }
    @Column(name = "number_cavities", nullable = false)
    private Integer numberCavities;
    @Column(name = "number_working_cavities", nullable = false)
    private Integer numberWorkingCavities;
    @Column(name = "plan_cycle_time")
    private Integer planCycleTime;
    @Column(name = "insert_mount_time")
    private Integer insertMountTime;
    @Column(name = "insert_release_time")
    private Integer insertReleaseTime;
    @Column(name = "single_insert")
    @ColumnDefault("true")
    private boolean singleInsert;
    @Column(name = "insert_mounted")
    @ColumnDefault("true")
    private boolean insertMounted;
    @ManyToOne(targetEntity = MoldModifier.class)
    @JoinColumn(name = "insert_mounted_to", referencedColumnName = "equipment_id")
    private MoldModifier insertMountedTo;

    public boolean isInsertMounted() {
        return insertMounted;
    }

    public void setInsertMounted(boolean insertMounted) {
        if (!this.isSingleInsert()) {
            this.insertMounted = insertMounted;
        } else {
            this.insertMounted = true;
        }
    }

    public MoldModifier getInsertMountedTo() {
        return insertMountedTo;
    }

    /*
    public void setInsertMountedTo(MoldModifier insertMountedTo) {
        if (!this.isSingleInsert()) {
            this.insertMountedTo = insertMountedTo;
        } else {
            if (this.insertMountedTo == null) {
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                Query query = session.createQuery("select moldModifier from InsertToModifierEntity where moldInsert = :param");
                query.setParameter("param", this);
                MoldModifier moldModifier = (MoldModifier) query.uniqueResult();
                session.close();
                this.insertMountedTo = moldModifier;
            }
        }
    }*/

    public int getNumberCavities() {
        return numberCavities;
    }

    public void setNumberCavities(Integer numberCavities) {
        this.numberCavities = numberCavities;
    }

    public Integer getNumberWorkingCavities() {
        return numberWorkingCavities;
    }

    public void setNumberWorkingCavities(Integer numberWorkingCavities) {
        this.numberWorkingCavities = numberWorkingCavities;
    }

    public Integer getPlanCycleTime() {
        return planCycleTime;
    }

    public void setPlanCycleTime(Integer planCycleTime) {
        this.planCycleTime = planCycleTime;
    }

    public Integer getInsertMountTime() {
        return insertMountTime;
    }

    public void setInsertMountTime(Integer insertMountTime) {
        this.insertMountTime = insertMountTime;
    }

    public Integer getInsertReleaseTime() {
        return insertReleaseTime;
    }

    public void setInsertReleaseTime(int insertReleaseTime) {
        this.insertReleaseTime = insertReleaseTime;
    }

    public boolean isSingleInsert() {
        return singleInsert;
    }

    public void setSingleInsert(boolean singleInsert) {
        this.singleInsert = singleInsert;
    }
}
