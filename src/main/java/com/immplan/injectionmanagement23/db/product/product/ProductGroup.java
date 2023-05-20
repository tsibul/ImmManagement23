package com.immplan.injectionmanagement23.db.product.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product_group")
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_group_id")
    private Long productGroupId;
    @Column(name = "product_group_name", length = 40, nullable = false)
    private String productGroupName;
    @Column(name = "product_group active", columnDefinition = "boolean default true", nullable = false)
    private boolean productGroupActive = true;

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public boolean isProductGroupActive() {
        return productGroupActive;
    }

    public void setProductGroupActive(boolean productGroupActive) {
        this.productGroupActive = productGroupActive;
    }
}
