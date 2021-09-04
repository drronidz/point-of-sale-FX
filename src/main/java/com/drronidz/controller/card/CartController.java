package com.drronidz.controller.card;

import com.drronidz.controller.drawer.FilterProductDrawerController;
import com.drronidz.controller.listcell.CartCellController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
    public JFXListView<Product> cartListView;

    @FXML
    private Label subTotal;

    @FXML
    private Label tvaTaxe;

    @FXML
    private Label discount;

    @FXML
    public Label total;

    Product selectedProduct;


    // so important for the total value to work !
    public ObservableList<Product> products = FXCollections.observableArrayList(
            item -> new Observable[] {item.demandQuantityProductProperty()});

    // Products Change Listener "List"
    ListChangeListener<Product> listChangeListener = c -> {
        // handles changes from filter product drawer (via checkbox)
        // Handle changes from Cart list cell (update +/- quantity buttons)
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
                if(cartListView.getItems().size() == 0) {
                    selectedProduct = null;
                }

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
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products.clear();
        cartListView.setItems(products);
        cartListView.setCellFactory( cartCell  -> new CartCellController());
        cartListView.getItems().addListener(listChangeListener);

    }



    public void handleProductCardDetails(ProductCardController productController) {
        cartListView.setOnMouseClicked(mouseEvent -> {
            selectedProduct = cartListView.getSelectionModel().getSelectedItem();

            if(selectedProduct != null) {
                productController.productCardSetup(selectedProduct);
                System.out.println("clicked on : " + selectedProduct.toString());
            } else {
                // Later to be implemented as Notification
                productController.productCardSetup(null);
                System.out.println("the cart is empty");
            }
        });
        ListChangeListener<Product> productCardChangeListener = c -> {
            while (c.next()) {
                if(cartListView.getItems().size() == 0) {
                    productController.productCardSetup(null);
                }
//                else {
//                    productController.productCardSetup(cartListView.getItems().get(0));
//                }
            }
        };
        cartListView.getItems().addListener(productCardChangeListener);

    }
}
