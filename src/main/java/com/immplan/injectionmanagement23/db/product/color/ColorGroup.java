package com.immplan.injectionmanagement23.db.product.color;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "color_group")
public class ColorGroup {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_group_id")
    private Long colorGroupId;
    @Column(name = "color_group_name", length = 40, nullable = false)
    private String colorGroupName;

    public Long getColorGroupId() {
        return colorGroupId;
    }

    public String getColorGroupName() {
        return colorGroupName;
    }

    public void setColorGroupName(String colorGroupName) {
        this.colorGroupName = colorGroupName;
    }
}
