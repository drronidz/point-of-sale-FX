package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 3:51 PM
*/

import com.drronidz.Main;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXDrawer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML public CartController cartController;
    @FXML public JFXDrawer enterOrScanDrawer;

    private List<Product> productList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productList.add(
                new Product(
                        "1",
                        "661244889988",
                        "Gorillaz",
                        "Converse",
                        "Black",
                        "43",
                        70.00,
                        10,
                        100,
                        7,
                        true,
                        true,
                        "peace",
                        0,
                        100,
                        "image",
                        LocalDateTime.now())
        );
        try {
            GridPane gridPane = (GridPane) Main.loadFXML("drawer","filterProductDrawer");
            enterOrScanDrawer.setSidePane(gridPane);
            enterOrScanDrawer.toBack();
        } catch (IOException e) {
            e.printStackTrace();
        }


        cartController.enterOrScan.setOnAction(mouseEvent -> {
//            Random random = new Random();
//            System.out.println(productList.get(random.nextInt(productList.size())));
//            cartController.products.addAll(productList.get(random.nextInt(productList.size())));
            if(enterOrScanDrawer.isOpened()) {
                enterOrScanDrawer.toBack();
                enterOrScanDrawer.close();
            }
            if(enterOrScanDrawer.isClosed()) {
                enterOrScanDrawer.toFront();
                enterOrScanDrawer.open();
            }
        });

        enterOrScanDrawer.setOnMouseClicked(mouseEvent -> {
                enterOrScanDrawer.close();
                enterOrScanDrawer.toBack();
        });
    }
}
