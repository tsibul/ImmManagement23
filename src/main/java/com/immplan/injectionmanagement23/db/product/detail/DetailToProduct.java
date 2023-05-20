package com.immplan.injectionmanagement23.db.product.detail;

import com.immplan.injectionmanagement23.db.product.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "detail_to_product")
public class DetailToProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_to_product_id")
    private Long detailToProductId;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product", referencedColumnName = "product_id", nullable = false)
    private Product product;
    @ManyToOne(targetEntity = Detail.class)
    @JoinColumn(name = "detail", referencedColumnName = "detail_id", nullable = false)
    private Detail detail;
    @Column(name = "detail_to_product_active", columnDefinition = "boolean default true", nullable = false)
    private boolean detailToProductActive = true;

    public Long getDetailToProductId() {
        return detailToProductId;
    }

    public void setDetailToProductId(Long detailToProductId) {
        this.detailToProductId = detailToProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public boolean isDetailToProductActive() {
        return detailToProductActive;
    }

    public void setDetailToProductActive(boolean detailToProductActive) {
        this.detailToProductActive = detailToProductActive;
    }
}
