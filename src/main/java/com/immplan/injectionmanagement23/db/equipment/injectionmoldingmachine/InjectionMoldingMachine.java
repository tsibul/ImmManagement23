package com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "injection_molding_machine")
public class InjectionMoldingMachine extends Equipment {
    @Column(name = "clamping_force_kN", nullable = false)
    private int clampingForceKn;
    @Column(name = "plate_height_mm", nullable = false)
    private int plateHeightMm;
    @Column(name = "plate_width_mm", nullable = false)
    private int plateWidthMm;
    @Column(name = "column_gap_mm", nullable = false)
    private int columnGapMm;
    @Column(name = "column_gap_vertical_mm")
    private int columnGapVerticalMm;
    @Column(name = "stroke_volume_cm3", nullable = false)
    private int strokeVolumeCm3;
    @Column(name = "stroke_weight_g", nullable = false)
    private int strokeWeightG;
    @Column(name = "height_mm", nullable = false)
    private int heightMm;
    @Column(name = "width_mm", nullable = false)
    private int widthMm;
    @Column(name = "length_mm", nullable = false)
    private int lengthMm;
    @Column(name = "weight_kg", nullable = false)
    private int weightKg;
    @Column(name = "electric_heat_capacity_W", nullable = false)
    private int electricHeatCapacityW;
    @Column(name = "electric_hydraulic_capacity_W")
    private int electricHydraulicCapacityW;
    @Column(name = "max_mold_weight_kg", nullable = false)
    private int maxMoldWeightKg;
    @Column(name = "min_mold_height_mm", nullable = false)
    private int minMoldHeightMm;
    @Column(name = "max_opening_mm", nullable = false)
    private int maxOpeningMm;
    @Column(name = "moving_plate_ring_diameter_mm")
    private int movingPlateRingDiameterMm;
    @Column(name = "fixed_plate_ring_diameter_mm")
    private int fixedPlateRingDiameterMm;
    @Column(name = "number_air_valves")
    private int numberAirValves;
    @Column(name = "number_hydraulic_valves")
    private int numberHydraulicValves;
    @Column(name = "hydraulic_connection_diameter_mm")
    private int hydraulicConnectionDiameterMm;
    @Column(name = "euromap_interface", nullable = false)
    private boolean euroMapInterface;
    @Column(name = "ejector_stroke")
    private int ejectorStrokeMm;
    @Column(name = "ejector_central")
    private boolean ejectorCentral;
    @Column(name = "imm_type", length = 50)
    private String immType;


    public int getClampingForceKn() {
        return clampingForceKn;
    }

    public void setClampingForceKn(int clampingForceKn) {
        this.clampingForceKn = clampingForceKn;
    }

    public int getPlateHeightMm() {
        return plateHeightMm;
    }

    public void setPlateHeightMm(int plateHeightMm) {
        this.plateHeightMm = plateHeightMm;
    }

    public int getPlateWidthMm() {
        return plateWidthMm;
    }

    public void setPlateWidthMm(int plateWidthMm) {
        this.plateWidthMm = plateWidthMm;
    }

    public int getColumnGapMm() {
        return columnGapMm;
    }

    public void setColumnGapMm(int columnGapMm) {
        this.columnGapMm = columnGapMm;
    }

    public int getColumnGapVerticalMm() {
        return columnGapVerticalMm;
    }

    public void setColumnGapVerticalMm(int columnGapVerticalMm) {
        this.columnGapVerticalMm = columnGapVerticalMm;
    }

    public int getStrokeVolumeCm3() {
        return strokeVolumeCm3;
    }

    public void setStrokeVolumeCm3(int strokeVolumeCm3) {
        this.strokeVolumeCm3 = strokeVolumeCm3;
    }

    public int getStrokeWeightG() {
        return strokeWeightG;
    }

    public void setStrokeWeightG(int strokeWeightG) {
        this.strokeWeightG = strokeWeightG;
    }

    public int getHeightMm() {
        return heightMm;
    }

    public void setHeightMm(int heightMm) {
        this.heightMm = heightMm;
    }

    public int getWidthMm() {
        return widthMm;
    }

    public void setWidthMm(int widthMm) {
        this.widthMm = widthMm;
    }

    public int getLengthMm() {
        return lengthMm;
    }

    public void setLengthMm(int lengthMm) {
        this.lengthMm = lengthMm;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public int getMaxMoldWeightKg() {
        return maxMoldWeightKg;
    }

    public void setMaxMoldWeightKg(int maxMoldWeightKg) {
        this.maxMoldWeightKg = maxMoldWeightKg;
    }

    public int getMinMoldHeightMm() {
        return minMoldHeightMm;
    }

    public void setMinMoldHeightMm(int minMoldHeightMm) {
        this.minMoldHeightMm = minMoldHeightMm;
    }

    public int getMovingPlateRingDiameterMm() {
        return movingPlateRingDiameterMm;
    }

    public void setMovingPlateRingDiameterMm(int movingPlateRingDiameterMm) {
        this.movingPlateRingDiameterMm = movingPlateRingDiameterMm;
    }

    public int getFixedPlateRingDiameterMm() {
        return fixedPlateRingDiameterMm;
    }

    public void setFixedPlateRingDiameterMm(int fixedPlateRingDiameterMm) {
        this.fixedPlateRingDiameterMm = fixedPlateRingDiameterMm;
    }

    public int getNumberAirValves() {
        return numberAirValves;
    }

    public void setNumberAirValves(int numberAirValves) {
        this.numberAirValves = numberAirValves;
    }

    public int getNumberHydraulicValves() {
        return numberHydraulicValves;
    }

    public void setNumberHydraulicValves(int numberHydraulicValves) {
        this.numberHydraulicValves = numberHydraulicValves;
    }

    public int getHydraulicConnectionDiameterMm() {
        return hydraulicConnectionDiameterMm;
    }

    public void setHydraulicConnectionDiameterMm(int hydraulicConnectionDiameterMm) {
        this.hydraulicConnectionDiameterMm = hydraulicConnectionDiameterMm;
    }

    public int getElectricHeatCapacityW() {
        return electricHeatCapacityW;
    }

    public void setElectricHeatCapacityW(int electricHeatCapacityW) {
        this.electricHeatCapacityW = electricHeatCapacityW;
    }

    public int getElectricHydraulicCapacityW() {
        return electricHydraulicCapacityW;
    }

    public void setElectricHydraulicCapacityW(int electricHydraulicCapacityW) {
        this.electricHydraulicCapacityW = electricHydraulicCapacityW;
    }

    public int getMaxOpeningMm() {
        return maxOpeningMm;
    }

    public void setMaxOpeningMm(int maxOpeningMm) {
        this.maxOpeningMm = maxOpeningMm;
    }

    public boolean isEuroMapInterface() {
        return euroMapInterface;
    }

    public void setEuroMapInterface(boolean euroMapInterface) {
        this.euroMapInterface = euroMapInterface;
    }

    public String getImmType() {
        return immType;
    }

    public void setImmType(String immType) {
        this.immType = immType;
    }

    public int getEjectorStrokeMm() {
        return ejectorStrokeMm;
    }

    public void setEjectorStrokeMm(int ejectorStrokeMm) {
        this.ejectorStrokeMm = ejectorStrokeMm;
    }

    public boolean isEjectorCentral() {
        return ejectorCentral;
    }

    public void setEjectorCentral(boolean ejectorCentral) {
        this.ejectorCentral = ejectorCentral;
    }
}
