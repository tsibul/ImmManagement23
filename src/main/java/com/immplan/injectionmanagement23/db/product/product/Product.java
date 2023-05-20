package com.immplan.injectionmanagement23.db.product.product;

import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_code", length = 14, nullable = false)
    private String productCode;
    @Column(name = "product_name", length = 40, nullable = false)
    private String productName;
    @Column(name = "number_details", nullable = false)
    private int numberDetails;
    @ManyToOne(targetEntity = ColorGroup.class)
    @JoinColumn(name = "color_group", referencedColumnName = "color_group_id")
    private MoldInsert colorGroup;
    @ManyToOne(targetEntity = ProductGroup.class)
    @JoinColumn(name = "product_group", referencedColumnName = "product_group_id")
    private ProductGroup productGroup;
    @Column(name = "product_active", columnDefinition = "boolean default true", nullable = false)
    private boolean productActive = true;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberDetails() {
        return numberDetails;
    }

    public void setNumberDetails(int numberDetails) {
        this.numberDetails = numberDetails;
    }

    public boolean isProductActive() {
        return productActive;
    }

    public void setProductActive(boolean productActive) {
        this.productActive = productActive;
    }

    public MoldInsert getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(MoldInsert colorGroup) {
        this.colorGroup = colorGroup;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}
