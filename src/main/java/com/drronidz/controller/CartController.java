package com.drronidz.controller;

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

    public ObservableList<Product> products = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

                @FXML
                private Label demandQte;

                @FXML
                private JFXButton incrementQte;

                @FXML
                private JFXButton decrimentQte;

                public FXMLLoader fxmlLoader;



                @Override
                protected void updateItem(Product item, boolean empty) {




                    super.updateItem(item, empty);
                    if (empty || (item == null)) {

                        setGraphic(null);
                        setText(null);
                    } else {
                        SimpleIntegerProperty integerProperty = new SimpleIntegerProperty();
                        integerProperty.set(item.getDemandQuantity());

                        if (fxmlLoader == null) {
                            try {
                                fxmlLoader = new FXMLLoader(getClass().getResource("/com/drronidz/listcell/cartcell.fxml"));
                                fxmlLoader.setController(this);
    //                            fxmlLoader.setRoot(this);
                                fxmlLoader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

//                            integerProperty.set(item.getDemandQuantity());

                            details.setText(item.getName() + " " + item.getSize() + " x"+ item.getDemandQuantity());
                            price.setText(String.valueOf(item.getPrice()));
                        }
                        setGraphic(cartCell);
                        incrementQte.setOnAction(actionEvent -> {
                            System.out.println("Increment Product Quantity");
                            item.setDemandQuantity(item.getDemandQuantity() + 1);
                            integerProperty.set(item.getDemandQuantity());

                        });

                        decrimentQte.setOnAction(actionEvent -> {
                            System.out.println("Decrement Product Quantity");
                            item.setDemandQuantity(item.getDemandQuantity() - 1);
                            integerProperty.set(item.getDemandQuantity());
                        });

                        demandQte.textProperty().bind(integerProperty.asString());
                    }

                }
            };
        });
//        enterOrScan.setOnAction(event -> {
//            System.out.println("Enter Or Scan Pressed !");
//            Random random = new Random();
//            System.out.println(productList.get(random.nextInt(productList.size())));
//            products.addAll(productList.get(random.nextInt(productList.size())));
//        });

    }
}
