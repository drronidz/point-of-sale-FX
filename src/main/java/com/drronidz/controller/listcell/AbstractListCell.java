package com.drronidz.controller.listcell;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/21/2021 12:51 AM
*/

import com.drronidz.Main;
import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.security.PublicKey;

public  class AbstractListCell <T> extends JFXListCell <T> {

    public static final String PATH_TYPE = "listcell";
    public static final String MAIN_PATH ="/com/drronidz/";
    public static final String SEPARATOR ="/";
    public static final String FILE_EXTENSION =".fxml";
    FXMLLoader fxmlLoader ;



    public void loadFXML(String fxml, Object controller, Object root) throws IOException {
       fxmlLoader = new FXMLLoader(controller.getClass()
                .getResource(
                        MAIN_PATH + PATH_TYPE + SEPARATOR + fxml + FILE_EXTENSION));
        fxmlLoader.setController(controller);
//        fxmlLoader.setRoot(root);
        fxmlLoader.load();
    }
}
