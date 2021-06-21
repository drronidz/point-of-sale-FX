package com.drronidz.controller.listcell;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/20/2021 12:20 AM
*/

import com.drronidz.Main;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListCell;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FilterProductCellController extends AbstractListCell<Product>  {

    @FXML
    private JFXListCell<Product> listCell;

    @FXML
    private GridPane filterProductCell;

    @FXML
    private Label details;

    @FXML
    private Label availableQuantity;

    @FXML
    private Label price;

    @FXML
    private Label discount;

    @FXML
    private Label taxe;

    @FXML
    private Label ref;

    @FXML
    private Label code;

    @FXML
    private Label barCode;

    @FXML
    private JFXCheckBox isChecked;



    @Override
    protected void updateItem(Product item, boolean empty) {

        super.updateItem(item, empty);
        if(empty || (item == null)) {
            setText(null);
            setGraphic(null);
        } else {

            if (fxmlLoader == null) {
                try {
                  loadFXML("filter_product_cell",this,this);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                details.setText(
                        item.getCategory() + " "
                                + item.getName() + " "
                                + item.getColor() + " "
                                + item.getSize()
                );
                price.setText(item.getSalePrice() + " $");
                discount.setText("-" + item.getDiscount() + "%");
                availableQuantity.setText(String.valueOf(item.getDemandQuantity()));
            }
            setGraphic(filterProductCell);
            setText(null);
        }

    }


}
