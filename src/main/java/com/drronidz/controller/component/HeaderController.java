package com.drronidz.controller.component;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 8/31/2021 3:09 PM
*/

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {
    @FXML
    private JFXButton back;

    @FXML
    private Label headerTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setHeaderTitle(String title) {
        headerTitle.setText(title);
    }

    public void backToMain(Node node) {
        back.setOnMouseClicked(mouseEvent -> {
            node.setVisible(false);
        });
    }
}
