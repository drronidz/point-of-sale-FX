package com.drronidz.controller.drawer.side.filter;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/2/2021 11:16 PM
*/

import com.drronidz.model.Entity;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public abstract class AbstractFilter<T extends Entity>{

    public ObservableList<T> products;
    public FilteredList<T> filteredData ;
    public void selectAll(JFXButton selectAll, ObservableList<T> items) {
        selectAll.setOnMouseClicked(mouseEvent -> {
            for (Entity item: items) {
                item.setSelected(true);
            }
        });
    }

    public void clearAll(JFXButton clearAll, ObservableList<T> items) {
        clearAll.setOnMouseClicked(mouseEvent -> {
            for (Entity product: items) {
                product.setSelected(false);
            }
        });
    }

    public Predicate<T> createPredicate (String searchText) {
        return product -> {
            if(searchText == null || searchText.isEmpty()) return true;
            return searchFindsProduct(product, searchText);
        };
    }

    public abstract boolean searchFindsProduct(T item, String searchText);

    public void searchByDetails(JFXTextField searchByDetails) {
        searchByDetails.textProperty().addListener((observable, oldValue, newValue) ->
                filteredData.setPredicate(createPredicate(newValue))
        );
    }

}
