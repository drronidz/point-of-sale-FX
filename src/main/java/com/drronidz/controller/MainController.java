package com.drronidz.controller;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 3:51 PM
*/

import com.drronidz.Main;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
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
        productList.add(new Product("1","#CONV01","Converse Gorillaz", "43",50.00 ,1,100,"url"));
        productList.add(new Product("2","#CONV02","Converse AllStar", "43",50.00 ,1,100,"url"));
        productList.add(new Product("3","#CONV03","Converse Magnum", "43",50.00 ,1,100,"url"));
        productList.add(new Product("4","#CONV04","Converse BlackStar", "43",50.00 ,1,100,"url"));

        try {
            GridPane gridPane = (GridPane) Main.loadFXML("drawer","filterProductDrawer");
            enterOrScanDrawer.setSidePane(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }


        cartController.enterOrScan.setOnAction(mouseEvent -> {
//            Random random = new Random();
//            System.out.println(productList.get(random.nextInt(productList.size())));
//            cartController.products.addAll(productList.get(random.nextInt(productList.size())));
            if(enterOrScanDrawer.isClosed()) {
                enterOrScanDrawer.open();
            } else {
                enterOrScanDrawer.close();
            }
        });
    }
}
