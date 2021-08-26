package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/26/2021 2:33 PM
*/

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ToolsController extends GridPane implements Initializable {

    @FXML
    public JFXButton removeItem;

    @FXML
    public JFXButton discount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
