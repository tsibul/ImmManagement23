package com.immplan.injectionmanagement23.db.producer;

import jakarta.persistence.*;

@Entity
@Table(name = "producer_type")
public class ProducerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producer_type_id")
    private Long producerTypeId;

    @Column(name = "producer_type_name", length = 40, nullable = false)
    private String producerTypeName;
    @Column(name = "producer_type_active", columnDefinition = "boolean default true", nullable = false)
    private boolean producerTypeActive = true;

    public Long getProducerTypeId() {
        return producerTypeId;
    }

    public void setProducerTypeId(Long producerTypeId) {
        this.producerTypeId = producerTypeId;
    }

    public String getProducerTypeName() {
        return producerTypeName;
    }

    public void setProducerTypeName(String producerTypeName) {
        this.producerTypeName = producerTypeName;
    }

    public boolean isProducerTypeActive() {
        return producerTypeActive;
    }

    public void setProducerTypeActive(boolean producerTypeActive) {
        this.producerTypeActive = producerTypeActive;
    }
}
