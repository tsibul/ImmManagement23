package com.immplan.injectionmanagement23.db.product.detail;


import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.product.product.Product;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import jakarta.persistence.*;

@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "detail_code", referencedColumnName = "product_code")
    private Product detailCode;
    @Column(name = "index_in_product", nullable = false)
    private Integer indexInProduct;
    @Column(name = "detail_name", nullable = false)
    private String detailName;
    @Column(name = "detail_base_weight_g", precision = 1, nullable = false)
    private Double detailBaseWeightG;
    @ManyToOne(targetEntity = MaterialType.class)
    @JoinColumn(name = "main_material", referencedColumnName = "material_id")
    private MaterialType materialType;
    @ManyToOne(targetEntity = MoldInsert.class)
    @JoinColumn(name = "mold_insert", referencedColumnName = "equipment_id", nullable = false)
    private MoldInsert moldInsert;
    @Column(name = "stroke_weight_g", precision = 1)
    private Double stokeWeightG;
    @Column(name = "gate_weight_g", precision = 1)
    private Double gateWeightG;
    @Column(name = "standard_items_per_box", nullable = false)
    private Integer standardItemsPerBox;
    @Column(name = "detail_active", columnDefinition = "boolean default true", nullable = false)
    private boolean detailActive = true;

    public Integer getIndexInProduct() {
        return indexInProduct;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public double getDetailBaseWeightG() {
        return detailBaseWeightG;
    }

    public void setDetailBaseWeightG(Double detailBaseWeightG) {
        this.detailBaseWeightG = detailBaseWeightG;
    }

      public MoldInsert getMoldInsert() {
        return moldInsert;
    }

    public void setMoldInsert(MoldInsert moldInsert) {
        this.moldInsert = moldInsert;
    }


    public Double getStokeWeightG() {
        return stokeWeightG;
    }

    public void setStokeWeightG(Double stokeWeightG) {
        this.stokeWeightG = stokeWeightG;
    }

    public Double getGateWeightG() {
        return gateWeightG;
    }

    public void setGateWeightG(Double gateWeightG) {
        this.gateWeightG = gateWeightG;
    }

    public Integer getStandardItemsPerBox() {
        return standardItemsPerBox;
    }

    public void setStandardItemsPerBox(Integer standardItemsPerBox) {
        this.standardItemsPerBox = standardItemsPerBox;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public boolean isDetailActive() {
        return detailActive;
    }

    public void setDetailActive(boolean detailActive) {
        this.detailActive = detailActive;
    }

    public Product getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(Product detailCode) {
        this.detailCode = detailCode;
    }

    public void setIndexInProduct(Integer indexInProduct) {
        this.indexInProduct = indexInProduct;
    }
}
