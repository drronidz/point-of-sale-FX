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

       handleOpenOrCloseFilterProductDrawer();
       handleAddToCart();
    }
    public void handleOpenOrCloseFilterProductDrawer() {
        // Open or Close Filter Product Drawer !
        cartController.enterOrScan.setOnAction(mouseEvent -> {
            filterProductDrawerController.openOrCloseDrawer();
        });
    }

    public void handleAddToCart () {
        // Handle add to Cart from Filter Product Drawer !
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
