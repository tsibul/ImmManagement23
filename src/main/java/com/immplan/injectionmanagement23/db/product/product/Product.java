package com.immplan.injectionmanagement23.db.product.product;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_code", length = 14, nullable = false, unique = true)
    @NaturalId
    private String productCode;
    @Column(name = "product_name", length = 40, nullable = false)
    private String productName;
    @Column(name = "number_details", nullable = false)
    private Integer numberDetails;
    @ManyToOne(targetEntity = ProductGroup.class)
    @JoinColumn(name = "product_group", referencedColumnName = "product_group_id", nullable = false)
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

    public Integer getNumberDetails() {
        return numberDetails;
    }

    public void setNumberDetails(Integer numberDetails) {
        this.numberDetails = numberDetails;
    }

    public boolean isProductActive() {
        return productActive;
    }

    public void setProductActive(boolean productActive) {
        this.productActive = productActive;
    }

     public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}
