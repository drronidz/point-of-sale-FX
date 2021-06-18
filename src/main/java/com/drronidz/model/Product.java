package com.drronidz.model;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/16/2021 1:06 AM
*/

public class Product {

    private String code;
    private String reference;
    private String name;
    private String size;
    private double price;
    private int demandQuantity;
    private int availableQuantity;
    private String urlImage;

    public Product(String code,
                   String reference,
                   String name,
                   String size,
                   double price,
                   int demandQuantity,
                   int availableQuantity,
                   String urlImage) {
        this.code = code;
        this.reference = reference;
        this.name = name;
        this.size = size;
        this.price = price;
        this.demandQuantity = demandQuantity;
        this.availableQuantity = availableQuantity;
        this.urlImage = urlImage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

//    @Override
//    public String toString() {
//        return "Product{" +
//                "code='" + code + '\'' +
//                ", reference='" + reference + '\'' +
//                ", name='" + name + '\'' +
//                ", size='" + size + '\'' +
//                ", price=" + price +
//                ", demandQuantity=" + demandQuantity +
//                ", availableQuantity=" + availableQuantity +
//                ", urlImage='" + urlImage + '\'' +
//                '}';
//    }
}
