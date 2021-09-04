package com.drronidz.controller.drawer;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 4:49 PM
*/


import com.drronidz.Main;
import com.drronidz.controller.card.CartController;
import com.drronidz.controller.drawer.side.filter.FilterProduct;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FilterProductDrawerController extends AbstractDrawer implements Initializable {

    final private static String FILTER_PRODUCT_SIDE = "filter_product";

    @FXML
    public JFXDrawer drawer;

    FilterProduct controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNode(FILTER_PRODUCT_SIDE, drawer);
        closeSidePane(drawer);
    }

    public void addItemToCart(CartController cartController) {
        // Handle add to Cart from Filter Product Drawer !
        for (Product product: controller.productListView.getItems()) {
            product.isSelectedFX().addListener(((observableValue, oldValue, newValue) -> {
                if(!newValue) {
                    cartController.cartListView.getItems().remove(product);
                } else {
                    product.setDemandQuantity(1);
                    cartController.cartListView.getItems().add(product);
                }
            }));
        }
    }

    @Override
    public void setNode(String viewName, JFXDrawer drawer) {
        try {
            FXMLLoader loader = Main.loadFXMLoader(PATH_FILTER, FILTER_PRODUCT_SIDE);
            Node node = loader.load();
            drawer.setSidePane(node);
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openSidePane(JFXButton open) {
        drawer.setOnDrawerOpening((event) -> drawer.setViewOrder(0));
        open.setOnMouseClicked(mouseEvent -> drawer.open());
    }
}
