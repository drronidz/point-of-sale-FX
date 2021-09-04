package com.drronidz.controller.table;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/4/2021 12:17 AM
*/

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class CategoryTableController {
    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> createdAt;

    @FXML
    private TableColumn<?, ?> updatedAt;

    @FXML
    private TableColumn<?, ?> isActive;

    @FXML
    private TableColumn<?, ?> isSelected;

    @FXML
    public JFXButton newCategory;

    @FXML
    public JFXButton editCategory;
}
