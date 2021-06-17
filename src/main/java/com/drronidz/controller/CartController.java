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

        productList.add(new Product("1","#CONV01","Converse Gorillaz", "43",50.00 ,1,100,"url"));
        productList.add(new Product("2","#CONV02","Converse AllStar", "43",50.00 ,1,100,"url"));
        productList.add(new Product("3","#CONV03","Converse Magnum", "43",50.00 ,1,100,"url"));
        productList.add(new Product("4","#CONV04","Converse BlackStar", "43",50.00 ,1,100,"url"));

        cart.setItems(products);
//        cart.setCellFactory( cartCell  -> new CartCellController());
        cart.setCellFactory((cartCell) -> {
            return new ListCell<Product>() {

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
                            details.setText(item.getName() + " " + item.getSize() + " x"+ item.getDemandQuantity());
                            price.setText(String.valueOf(item.getPrice()));
                        }
                        setGraphic(cartCell);
                    }
                }
            };
        });
        enterOrScan.setOnAction(event -> {
            System.out.println("Enter Or Scan Pressed !");
            System.out.println(productList.get(0));
            products.addAll(productList.get(0));
        });

    }
}
