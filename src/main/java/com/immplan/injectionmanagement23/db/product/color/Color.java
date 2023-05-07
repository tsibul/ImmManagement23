package com.immplan.injectionmanagement23.db.product.color;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "color")
public class Color {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Long colorId;
    @Column(name = "color_code", length = 8, nullable = false)
    private String colorCode;
    @Column(name = "color_name", length = 40, nullable = false)
    private String colorName;
    @Column(name = "color_pantone", length = 20, nullable = false)
    private String colorPantone;
    @Column(name = "color_hex", length = 7, nullable = false)
    private String colorHEX;
    @ManyToOne(targetEntity = ColorGroup.class)
    @JoinColumn(name = "color_group", referencedColumnName = "color_group_id", nullable = false)
    private ColorGroup colorGroup;

    public Long getColorId() {
        return colorId;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorPantone() {
        return colorPantone;
    }

    public void setColorPantone(String colorPantone) {
        this.colorPantone = colorPantone;
    }

    public String getColorHEX() {
        return colorHEX;
    }

    public void setColorHEX(String colorHEX) {
        this.colorHEX = colorHEX;
    }

    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(ColorGroup colorGroup) {
        this.colorGroup = colorGroup;
    }
}
