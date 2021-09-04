package com.drronidz.model;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/3/2021 12:09 AM
*/

import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalDateTime;

public abstract class Entity {
    public long id;

    public String name;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;

    public String description;

    public boolean isSelected;
    public SimpleBooleanProperty selectFX;

    public boolean isActive;
    public SimpleBooleanProperty activeFX;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return this.selectFX.get();
    }
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        this.selectFX.set(selected);
    }

    public boolean isActive() {
        return this.activeFX.get();
    }
    public void setActive(boolean active) {
        this.isActive = active;
        this.activeFX.set(active);
    }

    // FX Properties For Binding ...
    public SimpleBooleanProperty isSelectedFX() {
        return selectFX;
    }
    public SimpleBooleanProperty isActiveFX() {
        return activeFX;
    }
}
