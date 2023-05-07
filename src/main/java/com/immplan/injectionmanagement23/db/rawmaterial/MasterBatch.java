package com.immplan.injectionmanagement23.db.rawmaterial;


import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.product.color.Color;
import jakarta.persistence.*;

@Entity
@Table(name = "masterbatch")
public class MasterBatch extends Material{
    @Column(name = "color_name",length = 40, nullable = false)
    private String colorName;
    @ManyToOne(targetEntity = Color.class)
    @JoinColumn(name = "detail_color", referencedColumnName = "color_id")
    private Color color;
    @Column(name = "standard_doze", precision = 2)
    private double standardDoze;
    @ManyToOne(targetEntity = Producer.class)
    @JoinColumn(name = "producer", referencedColumnName = "id", nullable = false)
    private Producer producer;
    @ManyToOne(targetEntity = MaterialType.class)
    @JoinColumn(name = "main_material", referencedColumnName = "material_id")
    private MaterialType standardMaterialType;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getStandardDoze() {
        return standardDoze;
    }

    public void setStandardDoze(double standardDoze) {
        this.standardDoze = standardDoze;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public MaterialType getStandardMaterialType() {
        return standardMaterialType;
    }

    public void setStandardMaterialType(MaterialType standardMaterialType) {
        this.standardMaterialType = standardMaterialType;
    }
}
