package com.drronidz.controller;

import com.drronidz.controller.listcell.CartCellController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class CartController extends GridPane implements Initializable {

    @FXML
    public JFXButton enterOrScan;

    @FXML
    private JFXListView<Product> cart;

    @FXML
    private Label subTotal;

    @FXML
    private Label tvaTaxe;

    @FXML
    private Label discount;

    @FXML
    private Label total;

    private List<Product> productList = new ArrayList<>();
    public ObservableList<Product> products = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Product productOne = new Product(
                "1",
                "661244889988",
                "Gorillaz",
                "Converse",
                "Black",
                "43",
                70.00,
                10,
                100,
                7,
                true,
                false,
                "peace",
                0,
                100,
                "image",
                LocalDateTime.now()
        );

        cart.setItems(products);
        cart.setCellFactory( cartCell  -> new CartCellController());
        enterOrScan.setOnMouseClicked(event -> {
            System.out.println("Enter Or Scan Pressed !");
            productOne.setDemandQuantity(1);
            products.addAll(productOne);
        });

    }
}
