package com.immplan.injectionmanagement23.db.producer;


import jakarta.persistence.*;

@Entity
@Table(name = "country")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String countryName;
    @Column(name = "country_active", columnDefinition = "boolean default true", nullable = false)
    private boolean countryActive = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isCountryActive() {
        return countryActive;
    }

    public void setCountryActive(boolean countryActive) {
        this.countryActive = countryActive;
    }
}
