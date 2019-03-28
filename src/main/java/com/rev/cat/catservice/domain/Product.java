package com.rev.cat.catservice.domain;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Product extends GenericDomain {

    private String name;
    private String description;
    private Catalog catalog;
    private Brand brand;
    private Integer stock;
    private double price;

    private List<Byte[]> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Byte[]> getImage() {
        return image;
    }

    public void setImage(List<Byte[]> image) {
        this.image = image;
    }
}
