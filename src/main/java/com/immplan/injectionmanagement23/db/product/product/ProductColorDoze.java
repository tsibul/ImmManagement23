package com.immplan.injectionmanagement23.db.product.product;

import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.rawmaterial.MasterBatch;
import jakarta.persistence.*;

@Entity
@Table(name = "product_color_code")
public class ProductColorDoze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_color_doze_id")
    private Long productColorDozeId;
    @ManyToOne(targetEntity = ProductGroup.class)
    @JoinColumn(name = "product_group", referencedColumnName = "product_group_id")
    private ProductGroup productGroup;
    @ManyToOne(targetEntity = MasterBatch.class)
    @JoinColumn(name = "masterbatch", referencedColumnName = "material_id")
    private MasterBatch masterBatch;
    @ManyToOne(targetEntity = Color.class)
    @JoinColumn(name = "color", referencedColumnName = "color_id")
    private Color color;
    @Column(name = "doze", precision = 2)
    private double doze;
    @Column(name = "product_color_doze_active", columnDefinition = "boolean default true", nullable = false)
    private boolean productColorDozeActive = true;

    public Long getProductColorDozeId() {
        return productColorDozeId;
    }

    public void setProductColorDozeId(Long productColorDozeId) {
        this.productColorDozeId = productColorDozeId;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public MasterBatch getMasterBatch() {
        return masterBatch;
    }

    public void setMasterBatch(MasterBatch masterBatch) {
        this.masterBatch = masterBatch;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDoze() {
        return doze;
    }

    public void setDoze(double doze) {
        this.doze = doze;
    }

    public boolean isProductColorDozeActive() {
        return productColorDozeActive;
    }

    public void setProductColorDozeActive(boolean productColorDozeActive) {
        this.productColorDozeActive = productColorDozeActive;
    }
}
