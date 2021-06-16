package com.drronidz.controller;

import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController extends GridPane implements Initializable {

    @FXML
    private JFXButton enterOrScan;

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

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cart.setCellFactory( cartCell  -> new CartCellController());
        enterOrScan.setOnAction(event -> {
            products.add(new Product("Converse Gorillaz",50.00, "43"));
            cart.setItems(products);
            System.out.println("Enter Or Scan Pressed !");
        });
    }
}
