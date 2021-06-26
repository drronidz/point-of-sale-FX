package com.drronidz.controller.drawer;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 4:49 PM
*/

import com.drronidz.controller.CartController;
import com.drronidz.controller.listcell.FilterProductCellController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FilterProductDrawerController implements Initializable {

    @FXML
    public HBox drawer;

    @FXML
    public VBox overlay;

    @FXML
    public JFXListView<Product> productListView;

    @FXML
    private JFXTextField searchByDetails;

    @FXML
    public JFXButton clearSelection;

    @FXML
    private JFXButton addAllToCart;

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Product productOne = new Product(
                "1",
                "661244889988",
                "AllStars",
                "Converse",
                "Red",
                "43",
                70.00,
                10,
                100,
                7,
                true,
                false,
                "peace",
                0,
                30,
                "image",
                LocalDateTime.now()
        );

        Product productTwo = new Product(
                "1",
                "661244889988",
                "BlackStart",
                "Converse",
                "Blue",
                "43",
                80.00,
                10,
                135,
                7,
                true,
                false,
                "peace",
                0,
                40,
                "image",
                LocalDateTime.now()
        );

        Product productThree = new Product(
                "1",
                "661244889988",
                "SkyStar",
                "Converse",
                "White",
                "43",
                90.00,
                10,
                85,
                7,
                true,
                false,
                "peace",
                0,
                50,
                "image",
                LocalDateTime.now()
        );
        products.addAll(productOne,productTwo,productThree);
        productListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        productListView.setItems(products);
        productListView.setCellFactory(filterProductCell -> new FilterProductCellController());

        handleAddAll();
        handleClearSelection();






    }

    public void handleClearSelection() {
        clearSelection.setOnMouseClicked(mouseEvent -> {
            System.out.println("clear selection (uncheck JFXCheckbox)");
            for (Product product: products) {
                product.setSelected(false);
            }
        });
    }

    public void handleAddAll() {
        addAllToCart.setOnMouseClicked(mouseEvent -> {
            for (Product product: products) {
                product.setSelected(true);
            }
        });
    }

    public void openOrCloseDrawer() {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);

        openNav.setToX(0);

        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);

            if (drawer.getTranslateX() != 0) {
                openNav.play();
                drawer.toFront();
            } else {
                closeNav.setToX(-(drawer.getWidth()));
                closeNav.play();
            }

        overlay.setOnMouseClicked(mouseEvent -> {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
        });
    }



}
