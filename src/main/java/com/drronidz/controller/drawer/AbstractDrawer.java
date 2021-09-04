package com.drronidz.controller.drawer;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/2/2021 11:10 PM
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;

public abstract class AbstractDrawer {
    final public static String PATH_FILTER = "drawer/side/filter";
    final public static String PATH_FORM = "drawer/side/form";

    public abstract void setNode(String viewName, JFXDrawer drawer);
    public abstract void openSidePane(JFXButton open);
    public void closeSidePane(JFXDrawer drawer) {
        drawer.setOnDrawerClosing((event) -> drawer.setViewOrder(1));
        drawer.setOnMouseClicked(mouseEvent -> drawer.close());
    }
    public void closeSidePane(JFXDrawer drawer, JFXButton button) {
        drawer.setOnDrawerClosing((event) -> drawer.setViewOrder(1));
        button.setOnMouseClicked(mouseEvent -> drawer.close());
    }

}
