package com.immplan.injectionmanagement23.db.product.detail;


import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.product.Product;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "detail")
public class Detail {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;
    @Column(name = "detail_name", nullable = false)
    private String detailName;
    @Column(name = "detail_base_weight_g", precision = 1, nullable = false)
    private double detailBaseWeightG;
    @ManyToOne(targetEntity = MaterialType.class)
    @JoinColumn(name = "main_material", referencedColumnName = "material_id")
    private MaterialType materialType;
    @ManyToOne(targetEntity = MoldInsert.class)
    @JoinColumn(name = "mold_insert", referencedColumnName = "equipment_id", nullable = false)
    private MoldInsert moldInsert;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product", referencedColumnName = "product_id", nullable = false)
    private Product product;
    @Column(name = "index_in_product", nullable = false)
    private int indexInProduct;
    @Column(name = "stroke_weight_g", precision = 1)
    private double stokeWeightG;
    @Column(name = "gate_weight_g", precision = 1)
    private double gateWeightG;
    @Column(name = "standard_items_per_box", nullable = false)
    private int standardItemsPerBox;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getIndexInProduct() {
        return indexInProduct;
    }

    public void setIndexInProduct(int indexInProduct) {
        if (indexInProduct <= this.product.getNumberDetails() && indexInProduct > 0) {
            this.indexInProduct = indexInProduct;
        }
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

    public void setDetailBaseWeightG(int detailBaseWeightG) {
        this.detailBaseWeightG = detailBaseWeightG;
    }

      public MoldInsert getMoldInsert() {
        return moldInsert;
    }

    public void setMoldInsert(MoldInsert moldInsert) {
        this.moldInsert = moldInsert;
    }

    public void setDetailBaseWeightG(double detailBaseWeightG) {
        this.detailBaseWeightG = detailBaseWeightG;
    }

    public double getStokeWeightG() {
        return stokeWeightG;
    }

    public void setStokeWeightG(double stokeWeightG) {
        this.stokeWeightG = stokeWeightG;
    }

    public double getGateWeightG() {
        return gateWeightG;
    }

    public void setGateWeightG(double gateWeightG) {
        this.gateWeightG = gateWeightG;
    }

    public int getStandardItemsPerBox() {
        return standardItemsPerBox;
    }

    public void setStandardItemsPerBox(int standardItemsPerBox) {
        this.standardItemsPerBox = standardItemsPerBox;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
