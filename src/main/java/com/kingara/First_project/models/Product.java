package com.kingara.First_project.models;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "productname")
    private String productname;
    @Column(name = "productdesciption")
    private String productdescription;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "stock")
    private int stock;
    @Column(name = "available")
    private boolean available;

    public Product() {

    }

    public Product(String productname, String productdescription, String supplier, int stock, boolean available) {
        this.productname = productname;
        this.productdescription = productdescription;
        this.supplier = supplier;
        this.stock = stock;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
