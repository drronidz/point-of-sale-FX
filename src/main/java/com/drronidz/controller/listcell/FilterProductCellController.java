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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class FilterProductCellController extends JFXListCell<Product> {
    @FXML
    private GridPane filterProductCell;

    @FXML
    private Label details;

    @FXML
    private Label availabeQuantity;

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
    private JFXCheckBox selectProduct;

    public FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || (item == null)) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                try {
                    Main.loadFXML(
                            "listcell",
                            "filter_product_cell",
                            this,
                            this);

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
                availabeQuantity.setText("x" + item.getAvailableQuantity());
            }
            setGraphic(filterProductCell);
            setText(null);

        }
    }
}
