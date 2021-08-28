package com.drronidz.controller;

import com.drronidz.controller.listcell.CartCellController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController extends GridPane implements Initializable {

    @FXML
    public JFXButton enterOrScan;

    @FXML
    public JFXListView<Product> cart;

    @FXML
    private Label subTotal;

    @FXML
    private Label tvaTaxe;

    @FXML
    private Label discount;

    @FXML
    private Label total;

    // so important for the total value to work !
    public ObservableList<Product> products = FXCollections.observableArrayList(
            item -> new Observable[] {item.demandQuantityProductProperty()});


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products.clear();
        cart.setItems(products);
        cart.setCellFactory( cartCell  -> new CartCellController());
        handleCartChanges();
    }
    public void handleCartChanges() {
        // handles changes from filter product drawer (via checkbox)
        // Handle changes from Cart list cell (update +/- quantity buttons)
        products.addListener((ListChangeListener<Product>) c -> {
            double subTotalValue = 0.0;
            while (c.next()) {
                if (c.wasUpdated()) {
                    System.out.println("Items from " + c.getFrom() + " to " + c.getTo() + " changed");
                    System.out.println("item updated is : " + c.getList().get(c.getFrom()).getName());
                    for (Product product: c.getList()) {
                        subTotalValue += product.getDemandQuantity() * product.getSalePrice();
                        subTotal.setText(String.valueOf(subTotalValue));
                    }
                } else if(c.wasRemoved()) {
                    Product removedItem = c.getRemoved().get(0);
                    for (Product product: products) {
                        subTotalValue += product.getSalePrice() * product.getDemandQuantity();
                    }
                    subTotal.setText(String.valueOf(subTotalValue));
                    System.out.println("subTotal is : " + subTotalValue);
                    System.out.println(removedItem + " removed!");

                } else if(c.wasAdded()) {
                    Product addedItem = c.getAddedSubList().get(0);
                    for (Product product: products) {
                        subTotalValue += product.getSalePrice() * product.getDemandQuantity();
                    }
                    subTotal.setText(String.valueOf(subTotalValue));
                    System.out.println("subTotal is : " + subTotalValue);
                    System.out.println(addedItem + " added!");
                }
            }
        });
    }
}
