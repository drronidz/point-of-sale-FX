package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 3:51 PM
*/

import com.drronidz.controller.drawer.FilterProductDrawerController;
import com.drronidz.model.Product;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML public CartController cartController;
//    @FXML public JFXDrawer enterOrScanDrawer;
    @FXML public FilterProductDrawerController filterProductDrawerController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Open or Close Drawer !
        cartController.enterOrScan.setOnAction(mouseEvent -> {
            filterProductDrawerController.openOrCloseDrawer();
        });
        for (Product product: filterProductDrawerController.productListView.getItems()) {
            if(!product.isSelected()) {
                product.setSelected(false);
                cartController.cart.getItems().remove(product);
                cartController.cart.refresh();
            }
        }
        // Add product form FilterProductDrawer to Cart
//        filterProductDrawerController.addToCart.setOnMouseClicked(mouseEvent -> {
//            System.out.println("addToCart pressed!");
//            ObservableList<Product> filterProductList = filterProductDrawerController.productListView.getItems();
//
//            for (Product product: filterProductList) {
//                if(product.isSelected()) {
//                    if(!cartController.cart.getItems().contains(product)) {
//                        System.out.println(product);
//                        product.setDemandQuantity(1);
//                        cartController.cart.getItems().add(product);
//                        cartController.cart.refresh();
//                    } else {
//                        System.out.println("product exists in the list");
//                    }
//                } else {
//                    System.out.println( product.toString() + " product product not selected list");
//                }
//            }
//        });

        for (Product product: filterProductDrawerController.productListView.getItems()) {
            product.isSelectedProductProperty().addListener(((observableValue, oldValue, newValue) -> {
                if(!product.isSelected()) {
                    cartController.products.remove(product);
                } else {
                    if(cartController.products.contains(product)) {
                        System.out.println("product already exists in the list");
                    } else {
                        product.setDemandQuantity(1);
                        cartController.products.add(product);
                    }
                }
            }));
        }
    }

}
