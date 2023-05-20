package com.immplan.injectionmanagement23.db.product.color;


import jakarta.persistence.*;

@Entity
@Table(name = "color_group")
public class ColorGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_group_id")
    private Long colorGroupId;
    @Column(name = "color_group_name", length = 40, nullable = false)
    private String colorGroupName;
    @Column(name = "color_group_active")
    private boolean colorGroupActive;

    public Long getColorGroupId() {
        return colorGroupId;
    }

    public String getColorGroupName() {
        return colorGroupName;
    }

    public void setColorGroupName(String colorGroupName) {
        this.colorGroupName = colorGroupName;
    }

    public void setColorGroupId(Long colorGroupId) {
        this.colorGroupId = colorGroupId;
    }

    public boolean isColorGroupActive() {
        return colorGroupActive;
    }

    public void setColorGroupActive(boolean colorGroupActive) {
        this.colorGroupActive = colorGroupActive;
    }
}
