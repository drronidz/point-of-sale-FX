package com.drronidz.controller.drawer;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/17/2021 4:49 PM
*/

import com.drronidz.controller.listcell.FilterProductCellController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FilterProductDrawerController implements Initializable {

    @FXML
    public JFXListView<Product> productListView;

    @FXML
    private JFXTextField searchByDetails;

    private List<Product> productList = new ArrayList<>();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Product productOne = new Product(
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
                false,
                "peace",
                0,
                100,
                "image",
                LocalDateTime.now()
        );
        Product productTwo = new Product(
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
                false,
                "peace",
                0,
                100,
                "image",
                LocalDateTime.now()
        );
        Product productThree = new Product(
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
                false,
                "peace",
                0,
                100,
                "image",
                LocalDateTime.now()
        );
        productList.addAll(
               List.of(productOne, productTwo, productThree)
        );
        products.addAll(productList);
        productListView.setItems(products);
        productListView.setCellFactory(filterProductCell -> new FilterProductCellController());
    }
}
