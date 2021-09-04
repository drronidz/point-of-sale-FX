package com.drronidz.controller.drawer;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/3/2021 2:13 PM
*/

import com.drronidz.Main;
import com.drronidz.controller.drawer.side.form.CategoryForm;
import com.drronidz.controller.table.CategoryTableController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryDrawerController extends AbstractDrawer implements Initializable {
    final private static String CATEGORY_FORM_SIDE = "category_form";

    @FXML
    private JFXDrawer drawer;

    @FXML private CategoryTableController categoryTableController;

    CategoryForm controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNode(CATEGORY_FORM_SIDE, drawer);
        openSidePane(categoryTableController.newCategory);
        closeSidePane(drawer);
        closeSidePane(drawer, controller.back);
        //controller.getBack(drawer);
    }

    @Override
    public void setNode(String viewName, JFXDrawer drawer) {
        try {
            FXMLLoader loader = Main.loadFXMLoader(PATH_FORM, viewName);
            Node node = loader.load();
            drawer.setSidePane(node);
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openSidePane(JFXButton open) {
        drawer.setOnDrawerOpening((event) -> drawer.setViewOrder(0));
        open.setOnMouseClicked(mouseEvent -> drawer.open());
    }
}
