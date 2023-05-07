package com.immplan.injectionmanagement23.db.rawmaterial;


import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.product.color.Color;
import jakarta.persistence.*;

@Entity
@Table(name = "main_material")
public class MainMaterial extends Material{
    @ManyToOne(targetEntity = MaterialType.class)
    @JoinColumn(name = "material_type", referencedColumnName = "material_id", nullable = false)
    private MaterialType materialType;

    @Column(name = "if_color")
    private boolean ifColor;
    @ManyToOne(targetEntity = Color.class)
    @JoinColumn(name = "color", referencedColumnName = "color_id")
    private Color color;
    @Column(name = "if_reused")
    private boolean ifReused;
    @ManyToOne(targetEntity = Producer.class)
    @JoinColumn(name = "producer", referencedColumnName = "id")
    private Producer producer;

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public boolean isIfColor() {
        return ifColor;
    }

    public void setIfColor(boolean ifColor) {
        this.ifColor = ifColor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isIfReused() {
        return ifReused;
    }

    public void setIfReused(boolean ifReused) {
        this.ifReused = ifReused;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
