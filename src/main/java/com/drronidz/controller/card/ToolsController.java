package com.drronidz.controller.card;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/26/2021 2:33 PM
*/

import com.drronidz.Main;
import com.drronidz.controller.container.ProductManagementController;
import com.drronidz.controller.dialog.ConfirmationDialog;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ToolsController extends GridPane implements Initializable {

    @FXML
    public JFXButton removeItem;

    @FXML
    public JFXButton discount;

    @FXML
    public JFXButton bag;

    Product selectedProduct;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showProductManagement(ProductManagementController productManagementController) {
        bag.setOnMouseClicked(mouseEvent -> {
            productManagementController.container.setVisible(true);
        });
    }
    public void removeSelectedProduct(CartController cartController, StackPane mainContainer) {
        removeItem.setOnMouseClicked(mouseEvent -> {
            System.out.println("attempt to remove item from the list !");
            selectedProduct = cartController.cartListView.getSelectionModel().getSelectedItem();
            if(selectedProduct != null) {
                ConfirmationDialog confirmationDialog =
                        new ConfirmationDialog(mainContainer,
                                "Are you sure of removing "+  selectedProduct.getName() + "?");
                confirmationDialog.confirm.setOnMouseClicked(confirmEvent -> {
                    cartController.cartListView.getItems().remove(selectedProduct);
                    selectedProduct.setSelected(false);
                    confirmationDialog.dialog.close();
                    selectedProduct = null;
                    // Later to be implemented as Notification
                    System.out.println("selected item removed successfully from the cart list view");
                });
                confirmationDialog.dismiss.setOnMouseClicked(dismissEvent ->{
                    confirmationDialog.dialog.close();
                });
            } else {
                // Later to be implemented as Notification
                System.out.println("there is no selected item from cart list view");
            }
        });
    }

}
