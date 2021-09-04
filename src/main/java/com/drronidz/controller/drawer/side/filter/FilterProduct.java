package com.drronidz.controller.drawer.side.filter;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/2/2021 3:05 PM
*/

import com.drronidz.controller.listcell.FilterProductCellController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class FilterProduct extends AbstractFilter<Product> implements Initializable {

    @FXML
    public JFXListView<Product> productListView;

    @FXML
    private JFXTextField searchByDetails;

    @FXML
    public JFXButton clearSelection;

    @FXML
    private JFXButton addAllToCart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products = FXCollections.observableArrayList();
        filteredData = new FilteredList<>(products);

        Product productOne = new Product(
                "1",
                "661244889988",
                "AllStars",
                "Converse",
                "Red",
                "43",
                70.00,
                15,
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

        Product productFour = new Product(
                "1",
                "661244889988",
                "SpaceX",
                "Converse",
                "Blue",
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


        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);
        products.add(productFour);


        productListView.setCellFactory(filterProductCell -> new FilterProductCellController());
        productListView.setItems(filteredData);

        searchByDetails(searchByDetails);
        selectAll(addAllToCart, products);
        clearAll(clearSelection, products);
    }

    @Override
    public boolean searchFindsProduct(Product product, String searchText) {
        return (
                (product.getName().toLowerCase().contains(searchText.toLowerCase())) ||
                        (product.getColor().toLowerCase().contains(searchText.toLowerCase()))
        );
    }
}
