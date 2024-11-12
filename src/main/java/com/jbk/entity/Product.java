package com.jbk.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int productQuantity;

    @Column(nullable = false)
    private double productPrice;

    @Column(nullable = false)
    private LocalDate mfgDate;

    @Column(nullable = false)
    private LocalDate expDate;

    //Default Constructor
    public Product(){
    }

    //Paramterized Constructor
    public Product (Long id, String productId, String productName, int productQuantity, double productPrice, LocalDate mfgDate, LocalDate expDate) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
    }

    // Getters and Setters
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getProductId () {
        return productId;
    }

    public void setProductId (String productId) {
        this.productId = productId;
    }

    public String getProductName () {
        return productName;
    }

    public void setProductName (String productName) {
        this.productName = productName;
    }

    public int getProductQuantity () {
        return productQuantity;
    }

    public void setProductQuantity (int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice () {
        return productPrice;
    }

    public void setProductPrice (double productPrice) {
        this.productPrice = productPrice;
    }

    public LocalDate getMfgDate () {
        return mfgDate;
    }

    public void setMfgDate (LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public LocalDate getExpDate () {
        return expDate;
    }

    public void setExpDate (LocalDate expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString () {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                ", mfgDate=" + mfgDate +
                ", expDate=" + expDate +
                '}';
    }
}
