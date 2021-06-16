package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @DRRONIDZ
DATE : 6/16/2021 1:05 AM
*/

import com.drronidz.Main;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class CartCellController extends JFXListCell<Product> {
    @FXML
    public GridPane cartCell;

    @FXML
    private Label details;

    @FXML
    private Label price;

    @FXML
    private Label ref;

    @FXML
    private Label code;

    public FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || (item == null)) {
            setText(null);
            setGraphic(null);
        } else {
            if(fxmlLoader == null) {
                try {
                    fxmlLoader = new FXMLLoader(Main.class.getResource("cart.fxml"));
                    fxmlLoader.setController(this);
                    fxmlLoader.setRoot(this);
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                details.setText(item.getName() + " " + item.getSize());
                price.setText(String.valueOf(item.getPrice()));

                setText(null);
                setGraphic(cartCell);
            }
        }
    }
}
