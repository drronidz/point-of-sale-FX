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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class CartCellController extends AbstractListCell<Product> {

    @FXML
    public GridPane cartCell;

    @FXML
    private Label details;

    @FXML
    private Label price;

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

    @Override
    protected void updateItem(Product item, boolean empty) {

        super.updateItem(item, empty);
        if (empty || (item == null)) {
            setGraphic(null);
            setText(null);
        } else {
            SimpleIntegerProperty integerProperty = new SimpleIntegerProperty();
            integerProperty.set(item.getDemandQuantity());

            if (fxmlLoader == null) {
                try {
                    loadFXML("cart_cell",this,this);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                details.setText(item.getName() + " " + item.getSize() + " x"+ item.getDemandQuantity());
                price.setText(String.valueOf(item.getSalePrice()));
            }

            setText(null);
            setGraphic(cartCell);

            incrementQte.setOnAction(actionEvent -> {
                System.out.println("Increment Product Quantity");
                item.setDemandQuantity(item.getDemandQuantity() + 1);
                integerProperty.set(item.getDemandQuantity());

            });

            decrementQte.setOnAction(actionEvent -> {
                System.out.println("Decrement Product Quantity");
                item.setDemandQuantity(item.getDemandQuantity() - 1);
                integerProperty.set(item.getDemandQuantity());
                if(item.getDemandQuantity() <= 0) {
                    getListView().getItems().remove(item);
                }
            });

            demandQuantity.textProperty().bind(integerProperty.asString());

        }
    }
}
