package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 3:51 PM
*/

import com.drronidz.Main;
import com.drronidz.controller.dialog.ConfirmationDialog;
import com.drronidz.controller.dialog.DiscountDialog;
import com.drronidz.controller.drawer.FilterProductDrawerController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXDrawer;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML public CartController cartController;
//    @FXML public JFXDrawer enterOrScanDrawer;
    @FXML public ToolsController toolsController;
    @FXML public FilterProductDrawerController filterProductDrawerController;

    @FXML private StackPane stackPane;
    @FXML private JFXDrawer drawer;


    Product selectedProduct ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            handleOpenOrCloseFilterProductDrawer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        handleAddToCart();

       cartController.cart.setOnMouseClicked(mouseEvent -> {

           selectedProduct = cartController.cart.getSelectionModel().getSelectedItem();
           if(selectedProduct != null) {
               System.out.println("clicked on : " + selectedProduct.getName());
           } else {
               // Later to be implemented as Notification
               System.out.println("the cart is empty");
           }
       });

       handleRemoveItemFromCart();
       handleDiscount();


    }
    public void handleOpenOrCloseFilterProductDrawer() throws IOException {
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

    public void handleRemoveItemFromCart() {
        // Remove Item from Cart via Tools.FXML (X : Button)
        toolsController.removeItem.setOnMouseClicked(mouseEvent -> {
            System.out.println("attempt to remove item from the list !");
            if(selectedProduct != null) {
                ConfirmationDialog confirmationDialog =
                        new ConfirmationDialog(stackPane,"Are you sure of this ?");
                confirmationDialog.confirm.setOnMouseClicked(confirmEvent -> {
                    cartController.cart.getItems().remove(selectedProduct);
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

    public void handleDiscount() {
        toolsController.discount.setOnMouseClicked(mouseEvent -> {
            System.out.println("handle discount here");
            if(selectedProduct != null) {
                System.out.println("handle discount for selected item !");
                DiscountDialog discountDialog = new DiscountDialog(stackPane, selectedProduct);

            } else {
                System.out.println("no selected item to add discount for !");
            }
        });

    }

}
