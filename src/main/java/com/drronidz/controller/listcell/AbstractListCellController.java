package com.drronidz.controller.listcell;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/21/2021 12:51 AM
*/

import com.drronidz.Main;
import com.drronidz.model.Product;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListCell;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.security.PublicKey;

public class AbstractListCellController<T> extends JFXListCell <T> {

    public static final String PATH_TYPE = "listcell";
    public static final String MAIN_PATH ="/com/drronidz/";
    public static final String SEPARATOR ="/";
    public static final String FILE_EXTENSION =".fxml";
    FXMLLoader fxmlLoader;

    public void loadFXML(String fxml, Object controller) throws IOException {
        fxmlLoader = new FXMLLoader();
        fxmlLoader  = new FXMLLoader(controller.getClass().getResource(MAIN_PATH + PATH_TYPE + SEPARATOR + fxml + FILE_EXTENSION));
        fxmlLoader.setController(controller);
//        fxmlLoader.setRoot(root);
        fxmlLoader.load();
    }


    public void bindCheckBox(JFXCheckBox checkBox, SimpleBooleanProperty booleanProperty) {
        checkBox.selectedProperty().bindBidirectional(booleanProperty);
    }

    public void bindLabel (Label label, SimpleIntegerProperty objectProperty) {
        label.textProperty().bindBidirectional(objectProperty,new NumberStringConverter());
    }
    public void bindLabel (Label label, SimpleDoubleProperty objectProperty) {
        label.textProperty().bindBidirectional(objectProperty,new NumberStringConverter());
    }

}
