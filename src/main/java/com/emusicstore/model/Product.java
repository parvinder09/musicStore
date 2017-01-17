package com.emusicstore.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by parvinder.kumar on 05-01-2017.
 */
@Entity
@Table(name="emusicstore")
public class Product {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="productid")
    private String productId;
    @Column(name="productname")
    @NotEmpty(message = "The product name must not be null.")
    private String productName;
    @Column(name="productcategory")
    private String productCategory;
    @Column(name="productdescription")
    private String productDescription;
    @Column(name="productprice")
    @Min(value=0,message = "The Product Price must not be less than zero.")
    private double productPrice;
    @Column(name="productcondition")
    private String productCondition;
    @Column(name="productstatus")
    private String productStatus;
    @Column(name="unitinstock")
    @Min(value=0,message = "The Product unit in stock must not be less than zero.")
    private int unitinstock;
    @Column(name="productmanufacturer")
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;


    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitinstock() {
        return unitinstock;
    }

    public void setUnitinstock(int unitinstock) {
        this.unitinstock = unitinstock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }
}
