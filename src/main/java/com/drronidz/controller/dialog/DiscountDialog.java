package com.drronidz.controller.dialog;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/28/2021 2:49 PM
*/

import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DiscountDialog extends GridPane implements Initializable {

    @FXML
    private JFXButton dismiss;

    @FXML
    private JFXButton confirm;

    @FXML
    private Label itemName;

    @FXML
    private ToggleButton percentage;

    @FXML
    private ToggleButton currency;

    @FXML
    private JFXTextField value;

    @FXML
    private Label valueType;

    public JFXDialog dialog = new JFXDialog();
    ToggleGroup toggleGroup = new ToggleGroup();

    public DiscountDialog(StackPane container, Product product) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/com/drronidz/dialog/discount_dialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            dialog.setContent(this);
            dialog.setDialogContainer(container);
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        itemName.setText(product.getName());
        value.setText(String.valueOf(product.getDiscount()));
        value.textProperty().bindBidirectional(product.discountProductProperty(),new NumberStringConverter());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        currency.setUserData("$");
        percentage.setUserData("%");

        currency.setToggleGroup(toggleGroup);
        percentage.setToggleGroup(toggleGroup);

        handleToggleDiscountType();

        confirm.setOnMouseClicked(mouseEvent -> {
            dialog.close();
        });
        dismiss.setOnMouseClicked(mouseEvent -> {
            dialog.close();
        });

    }

    public void handleToggleDiscountType(){
        toggleGroup.selectedToggleProperty().addListener((observableValue, oldValue, newValue) -> {
            System.out.println(observableValue);
            System.out.println(observableValue.getValue());
            if(newValue == null) {
                oldValue.setSelected(true);
                valueType.setText(String.valueOf(oldValue.getUserData()));
            } else {
                valueType.setText(String.valueOf(newValue.getUserData()));
            }
        });
    }
}
