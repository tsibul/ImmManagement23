package com.immplan.injectionmanagement23.db.producer;

import jakarta.persistence.*;

import static com.immplan.injectionmanagement23.db.producer.ProducerType.producerTypeDict;

@Entity
@Table(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 140, nullable = false)
    private String producerName;
    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country", referencedColumnName = "id")
    private Country country;
    @Column(name = "producer_type", nullable = false)
    private String producerType;
    @Column(name = "producer_type_id", nullable = false)
    private Integer producerTypeId;
    @Column(name = "producer_active", columnDefinition = "boolean default true", nullable = false)
    private boolean producerActive = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isProducerActive() {
        return producerActive;
    }

    public void setProducerActive(boolean producerActive) {
        this.producerActive = producerActive;
    }

    public String getProducerType() {
        return producerType;
    }

    public void setProducerType(Integer producerTypeId) {
        this.producerType = producerTypeDict().get(producerTypeId);
    }

    public void setProducerType(String producerType) {
        this.producerType = producerType;
    }

    public int getProducerTypeId() {
        return producerTypeId;
    }

    public void setProducerTypeId(Integer producerTypeId) {
        this.producerTypeId = producerTypeId;
    }
}
