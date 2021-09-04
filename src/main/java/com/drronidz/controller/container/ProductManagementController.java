package com.drronidz.controller.container;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 8/30/2021 10:43 PM
*/

import com.drronidz.Main;
import com.drronidz.controller.component.HeaderController;
import com.drronidz.controller.drawer.side.form.CategoryForm;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductManagementController implements Initializable {
    @FXML
    public GridPane container;

    @FXML
    JFXTabPane tabPane;
    @FXML
    Tab categories;

    @FXML
    private HeaderController headerController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        container.setVisible(false);
        headerController.backToMain(container);
    }
}
