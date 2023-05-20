package com.immplan.injectionmanagement23.db.product.detail;


import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.rawmaterial.MainMaterial;
import com.immplan.injectionmanagement23.db.rawmaterial.MasterBatch;
import jakarta.persistence.*;

@Entity
@Table(name = "detail_to_produce")
public class DetailToProduce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_to_produce_id")
    private Long detailToProduceId;
    @Column(name = "actual_weight_g", precision = 1)
    private double actualWeightG;
    @ManyToOne(targetEntity = MainMaterial.class)
    @JoinColumn(name = "actual_material", referencedColumnName = "material_id")
    private MainMaterial actualMaterial;
    @Column(name = "doze_master_batch", precision = 2, nullable = false)
    private double dozeMasterBatch;
    @ManyToOne(targetEntity = MasterBatch.class)
    @JoinColumn(name = "masterbatch_name", referencedColumnName = "material_id", nullable = false)
    private MasterBatch masterBatchName;
    @ManyToOne(targetEntity = Detail.class)
    @JoinColumn(name = "detail", referencedColumnName = "detail_id", nullable = false)
    private Detail detail;
    @ManyToOne(targetEntity = Color.class)
    @JoinColumn(name = "color", referencedColumnName = "color_id", nullable = false)
    private Color color;
    @Column(name = "items_per_box")
    private int itemsPerBox;
    @Column(name = "detail_to_produce_active", columnDefinition = "boolean default true", nullable = false)
    private boolean detailToProduceActive = true;


    public double getActualWeightG() {
        return actualWeightG;
    }

    public void setActualWeightG(int actualWeightG) {
        this.actualWeightG = actualWeightG;
    }

    public double getDozeMasterBatch() {
        return dozeMasterBatch;
    }

    public void setDozeMasterBatch(double dozeMasterBatch) {
        this.dozeMasterBatch = dozeMasterBatch;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setActualWeightG(double actualWeightG) {
        this.actualWeightG = actualWeightG;
    }

    public int getItemsPerBox() {
        return itemsPerBox;
    }

    public void setItemsPerBox(int itemsPerBox) {
        this.itemsPerBox = itemsPerBox;
    }

    public Long getDetailToProduceId() {
        return detailToProduceId;
    }

    public void setDetailToProduceId(Long detailToProduceId) {
        this.detailToProduceId = detailToProduceId;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public MainMaterial getActualMaterial() {
        return actualMaterial;
    }

    public void setActualMaterial(MainMaterial actualMaterial) {
        this.actualMaterial = actualMaterial;
    }

    public MasterBatch getMasterBatchName() {
        return masterBatchName;
    }

    public void setMasterBatchName(MasterBatch masterBatchName) {
        this.masterBatchName = masterBatchName;
    }

    public boolean isDetailToProduceActive() {
        return detailToProduceActive;
    }

    public void setDetailToProduceActive(boolean detailToProduceActive) {
        this.detailToProduceActive = detailToProduceActive;
    }
}
