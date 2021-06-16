package com.drronidz.controller;

import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class CartController implements Initializable {

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
    private List<Product> productList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productList.add(new Product("Converse Gorillaz", 50.00, "43"));
        productList.add(new Product("Converse AllStar", 100.00, "42"));
        productList.add(new Product("Converse Magnum", 150.00, "41"));
        productList.add(new Product("Converse BlackStar", 250.00, "40"));
        productList.add(new Product("Converse newGeneration", 350.00, "39"));
        cart.setItems(products);
//        cart.setCellFactory( cartCell  -> new CartCellController());
        cart.setCellFactory(cartCell -> new ListCell<Product>() {

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
                if (empty || (item == null)) {
                    setGraphic(null);
                    setText(null);
                } else {
                    if (fxmlLoader == null) {
                        try {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/drronidz/listcell/cart.fxml"));
                            fxmlLoader.setController(this);
//                            fxmlLoader.setRoot(this);
                            fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        details.setText(item.getName() + " " + item.getSize());
                        price.setText(String.valueOf(item.getPrice()));
                    }
                    setGraphic(cartCell);
                }
            }
        });
        products.clear();
        enterOrScan.setOnAction(event -> {
            System.out.println("Enter Or Scan Pressed !");
            System.out.println(productList.get(1));
            products.addAll(productList.get(1));

            cart.setItems(products);
            cart.refresh();
        });

    }
}
