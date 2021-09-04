package com.drronidz.controller.drawer.side.form;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 8/31/2021 10:44 PM
*/

import com.drronidz.tools.Validator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryForm implements Initializable {

    @FXML
    public Label title;

    @FXML
    public JFXButton back;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextArea description;

    @FXML
    private JFXButton browse;

    @FXML
    private JFXButton clear;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton cancel;

    public Validator validator = new Validator();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        validator.textFieldValidate(name);
        validator.textAreaValidator(description);
    }

}
