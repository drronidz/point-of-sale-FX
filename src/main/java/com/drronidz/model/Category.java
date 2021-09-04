package com.drronidz.model;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 8/31/2021 9:32 PM
*/

import javafx.beans.property.SimpleBooleanProperty;

public class Category extends Entity{


    private String icon;

    public Category() {
    }

    public Category(long id, String name, String description, String icon, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;

        // FX Properties
        this.selectFX = new SimpleBooleanProperty(isSelected);
        this.activeFX = new SimpleBooleanProperty(isActive);
    }


    public String getImageUrl() {
        return icon;
    }

    public void setImageUrl(String imageUrl) {
        this.icon = imageUrl;
    }
}
