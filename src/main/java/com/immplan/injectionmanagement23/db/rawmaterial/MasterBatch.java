package com.immplan.injectionmanagement23.db.rawmaterial;


import com.immplan.injectionmanagement23.db.producer.Producer;
import jakarta.persistence.*;

@Entity
@Table(name = "masterbatch")
public class MasterBatch extends Material{
    @Column(name = "color_name",length = 40, nullable = false)
    private String colorName;
    @ManyToOne(targetEntity = Producer.class)
    @JoinColumn(name = "producer", referencedColumnName = "id", nullable = false)
    private Producer producer;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

}
