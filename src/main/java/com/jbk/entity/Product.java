package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private int productQty;
    private double productPrice;
    private String mfgString;
    private String expString;

    public Product() {
        // TODO Auto-generated constructor stub
    }

    public Product(String productName, int productQty, double productPrice, String mfgString, String expString) {
        super();
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.mfgString = mfgString;
        this.expString = expString;
    }

    public Product(int productId, String productName, int productQty, double productPrice, String mfgString,
                   String expString) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.mfgString = mfgString;
        this.expString = expString;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getMfgString() {
        return mfgString;
    }

    public void setMfgString(String mfgString) {
        this.mfgString = mfgString;
    }

    public String getExpString() {
        return expString;
    }

    public void setExpString(String expString) {
        this.expString = expString;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productQty=" + productQty
                + ", productPrice=" + productPrice + ", mfgString=" + mfgString + ", expString=" + expString + "]";
    }

}
