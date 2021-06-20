package com.drronidz.model;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/16/2021 1:06 AM
*/

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

public class Product {

    private String code;
    private String barCode;
    private String name;
    private String category;
    private String color;
    private String size;
    private double cost;
    private int discount;
    private double salePrice;
    private double saleBeforeTaxe;
    private double taxes;
    private boolean isActive;
    private String unitOfMeasure;
    private int demandQuantity;
    private int availableQuantity;
    private String urlImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String code,
                   String barCode,
                   String name,
                   String category,
                   String color,
                   String size,
                   double cost,
                   int discount,
                   double saleBeforeTaxe,
                   double taxes,
                   boolean isActive,
                   String unitOfMeasure,
                   int demandQuantity,
                   int availableQuantity,
                   String urlImage,
                   LocalDateTime updatedAt) {
        this.code = code;
        this.barCode = barCode;
        this.name = name;
        this.category = category;
        this.color = color;
        this.size = size;
        this.cost = cost;
        this.discount = discount;
        this.saleBeforeTaxe = saleBeforeTaxe;
        this.taxes = taxes;
        this.salePrice = saleBeforeTaxe + (saleBeforeTaxe * taxes);
        this.isActive = isActive;
        this.unitOfMeasure = unitOfMeasure;
        this.demandQuantity = demandQuantity;
        this.availableQuantity = availableQuantity;
        this.urlImage = urlImage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getSaleBeforeTaxe() {
        return saleBeforeTaxe;
    }

    public void setSaleBeforeTaxe(double saleBeforeTaxe) {
        this.saleBeforeTaxe = saleBeforeTaxe;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxe) {
        this.taxes = taxe;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getDemandQuantity() {
        return demandQuantity;
    }

    public void setDemandQuantity(int demandQuantity) {
        this.demandQuantity = demandQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
