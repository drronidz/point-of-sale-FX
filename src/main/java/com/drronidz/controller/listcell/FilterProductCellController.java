package com.drronidz.controller.listcell;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/20/2021 12:20 AM
*/

import com.drronidz.model.Product;
import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class FilterProductCellController extends AbstractListCellController<Product> {

    private static final String FILTER_PRODUCT_CELL = "filter_product_cell";

    @FXML private GridPane filterProductCell;

    @FXML private Label details;

    @FXML private Label availableQuantity;

    @FXML private Label price;

    @FXML private Label discount;

    @FXML private Label taxe;

    @FXML private Label ref;

    @FXML private Label code;

    @FXML private Label barCode;

    @FXML private JFXCheckBox isChecked;

    FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        }
        else {
            if (fxmlLoader == null) {
                try {
                    loadFXML(FILTER_PRODUCT_CELL,this);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                details.setText(
                          item.getCategory() + " "
                        + item.getName() + " "
                        + item.getColor() + " "
                        + item.getSize());

                price.setText(String.valueOf(item.getSalePrice()));

                availableQuantity.setText(String.valueOf(item.getAvailableQuantity()));

                bindCheckBox(isChecked, item.isSelectedFX());

                bindLabel(availableQuantity, item.availableQuantityProductProperty());

                handleResetQty(item);
            }
            setText(null);
            setGraphic(filterProductCell);

        }
    }

    public void handleResetQty(Product item) {
        final int availableQty = item.getAvailableQuantity();
        ChangeListener<Boolean> resetListener = (observable, oldValue, newValue) -> {
            if(!newValue) {
                item.setAvailableQuantity(availableQty);
            } else {
                item.setAvailableQuantity(availableQty - 1);
            }
        };
        this.isChecked.selectedProperty().addListener(resetListener);
    }



}
