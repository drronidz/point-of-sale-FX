package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 3:51 PM
*/

import com.drronidz.controller.card.CartController;
import com.drronidz.controller.card.ProductCardController;
import com.drronidz.controller.card.ToolsController;
import com.drronidz.controller.container.ProductManagementController;
import com.drronidz.controller.dialog.DiscountDialog;
import com.drronidz.controller.drawer.FilterProductDrawerController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML public CartController cartController;
    @FXML public ToolsController toolsController;
    @FXML public ProductCardController productController;
    @FXML public FilterProductDrawerController filterProductDrawerController;
    @FXML public ProductManagementController productManagementController;
    @FXML private StackPane mainContainer;

    Product selectedProduct ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filterProductDrawerController.openSidePane(cartController.enterOrScan);
        filterProductDrawerController.addItemToCart(cartController);

        cartController.handleProductCardDetails(productController);

        toolsController.removeSelectedProduct(cartController, mainContainer);
        toolsController.showProductManagement(productManagementController);
        handleDiscount();
    }

    public void handleDiscount() {
        toolsController.discount.setOnMouseClicked(mouseEvent -> {
            System.out.println("handle discount here");
            if(selectedProduct != null) {
                System.out.println("handle discount for selected item !");
                DiscountDialog discountDialog = new DiscountDialog(mainContainer, selectedProduct);

            } else {
                System.out.println("no selected item to add discount for !");
            }
        });
    }

}
