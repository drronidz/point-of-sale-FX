package com.drronidz.controller.listcell;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/20/2021 12:20 AM
*/

import com.drronidz.Main;
import com.drronidz.controller.CartController;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListCell;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
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

public class FilterProductCellController extends AbstractListCell<Product> implements Initializable {

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
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                try {

                    loadFXML("filter_product_cell",this,this,null);

                    details.setText(
                            item.getCategory() + " "
                                    + item.getName() + " "
                                    + item.getColor() + " "
                                    + item.getSize()
                    );

                    price.setText(String.valueOf(item.getSalePrice()));

                    // Bind JFXCheckBox to SimpleBooleanProperty
                    // Add a Listener to SimpleBooleanProperty related JFXCheckbox

                    bindCheckBox(isChecked,item.isSelectedProductProperty());

                    item.isSelectedProductProperty().addListener(((observableValue, oldValue, newValue) -> {
                        item.setSelected(newValue);
                        item.setName(item.toString());
                        isChecked.setSelected(newValue);
                    }));

                    isChecked.selectedProperty().addListener(((observableValue, oldValue, newValue) -> {
                        item.setSelected(newValue);
                    }));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            setGraphic(filterProductCell);
            setText(null);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
