package com.drronidz.controller.listcell;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @DRRONIDZ
DATE : 6/16/2021 1:05 AM
*/


import com.drronidz.Main;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class CartCellController extends AbstractListCell<Product> implements Initializable {

    @FXML
    public GridPane cartCell;

    @FXML
    private Label details;

    @FXML
    private Label price;

    @FXML
    private Label discount;

    @FXML
    private Label ref;

    @FXML
    private Label code;

    @FXML
    private Label demandQuantity;

    @FXML
    private JFXButton incrementQte;

    @FXML
    private JFXButton decrementQte;

    FXMLLoader fxmlLoader;

    double subTotal;

    @Override
    protected void updateItem(Product item, boolean empty) {

        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {

            if (fxmlLoader == null) {
                try {
                    loadFXML("cart_cell",this,this,fxmlLoader);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bindLabel(demandQuantity,item.demandQuantityProductProperty());
                bindLabel(discount, item.discountProductProperty());
                details.setText(
                        item.getCategory() + " "
                                + item.getName() + " "
                                + item.getColor() + " "
                                + item.getSize()
                );
                price.setText(String.valueOf(item.getSalePrice()));
                price.setMinWidth(Region.USE_PREF_SIZE);
                discount.setText(String.valueOf(item.getDiscount()));

                handleIncrementQuantity(item);
                handleDecrementQuantity(item);
            }
            setText(null);
            setGraphic(cartCell);
        }
    }

    public void handleIncrementQuantity(Product item) {
        incrementQte.setOnAction(actionEvent -> {
            System.out.println("Increment Product Quantity");
            item.setDemandQuantity(item.getDemandQuantity() + 1);
        });
    }

    public void handleDecrementQuantity(Product item) {
        decrementQte.setOnAction(actionEvent -> {
            System.out.println("Decrement Product Quantity");
            item.setDemandQuantity(item.getDemandQuantity() - 1);
            if(item.getDemandQuantity() <= 0) {
                // Uncheck
                item.setSelected(false);
                getListView().getItems().remove(item);
                getListView().refresh();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
