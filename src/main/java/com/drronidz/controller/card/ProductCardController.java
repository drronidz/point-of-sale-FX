package com.drronidz.controller.card;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 8/30/2021 12:14 AM
*/

import com.drronidz.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductCardController implements Initializable {
    @FXML
    private Label noContent;

    @FXML
    private GridPane content;

    @FXML
    private ImageView image;

    @FXML
    public Label demandQuantity;

    @FXML
    private Label name;

    @FXML
    private Label ref;

    @FXML
    private Label code;

    @FXML
    private Label discount;

    @FXML
    private Label startingPrice;

    @FXML
    private Label endingPrice;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        content.setVisible(false);
        noContent.setVisible(true);
    }

    public void productCardSetup(Product product) {
        //image.setImage(new Image(product.getUrlImage()));
        if(product != null) {
            content.setVisible(true);
            noContent.setVisible(false);
            demandQuantity.setText(String.valueOf(product.getDemandQuantity()));
            name.setText(product.getCategory() + " " + product.getName());
            ref.setText(product.getBarCode());
            code.setText(product.getCode());
            discount.setText(product.getDiscount() + "%");
            endingPrice.setText(product.getSalePrice() + "$");
        } else {
            content.setVisible(false);
            noContent.setVisible(true);
        }

    }
}
