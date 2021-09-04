package com.drronidz.model;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/16/2021 1:06 AM
*/

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalDateTime;

public class Product extends Entity{

    private String code;
    private String barCode;
    private String category;
    private String color;
    private String size;
    private double cost;
    private int discount;
    private SimpleIntegerProperty discountProduct;
    private double salePrice;
    private SimpleDoubleProperty salePriceProduct;
    private double saleBeforeTaxe;
    private double taxes;


    private String unitOfMeasure;
    private int demandQuantity;
    private SimpleIntegerProperty demandQuantityProduct;
    private int availableQuantity;
    private SimpleIntegerProperty availableQuantityProdcut;
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
                   boolean selected,
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
        this.salePrice = saleBeforeTaxe + ((saleBeforeTaxe * taxes)/100);
        this.isActive = isActive;
        this.isSelected = selected;
        this.unitOfMeasure = unitOfMeasure;
        this.demandQuantity = demandQuantity;
        this.availableQuantity = availableQuantity;
        this.urlImage = urlImage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;

        // Simple Object Properties
        this.selectFX = new SimpleBooleanProperty(selected);
        this.activeFX = new SimpleBooleanProperty(isActive);
        this.demandQuantityProduct = new SimpleIntegerProperty(demandQuantity);
        this.salePriceProduct = new SimpleDoubleProperty(salePrice);
        this.discountProduct = new SimpleIntegerProperty(discount);
        this.availableQuantityProdcut = new SimpleIntegerProperty(availableQuantity);

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
        return discountProduct.get();
    }

    public void setDiscount(int discount) {
        this.discountProduct.set(discount);
        this.discount = discount;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePriceProduct.set(salePrice);
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





    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getDemandQuantity() {
        return this.demandQuantityProduct.get();
    }

    public void setDemandQuantity(int demandQuantity) {
        this.demandQuantity = demandQuantity;
        this.demandQuantityProduct.set(demandQuantity);
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
        this.availableQuantityProdcut.set(availableQuantity);
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

    // Simple Object Properties




    public SimpleIntegerProperty demandQuantityProductProperty() {
        return demandQuantityProduct;
    }

    public SimpleIntegerProperty  discountProductProperty() { return discountProduct; }

    public SimpleIntegerProperty availableQuantityProductProperty() {
        return availableQuantityProdcut;
    }
}
