package com.drronidz.controller.dialog;

/*
PROJECT NAME : PointOfSaleFX
USER NAME : @ DRRONIDZ
DATE : 6/26/2021 11:48 PM
*/

import com.drronidz.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmationDialog extends GridPane implements Initializable {

    @FXML
    public JFXButton dismiss;

    @FXML
    public JFXButton confirm;

    @FXML
    public Label message;

    public JFXDialog dialog = new JFXDialog();

    public ConfirmationDialog(StackPane container,String confirmationMessage) {

        try {
            FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/com/drronidz/dialog/confirmation_dialog.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            dialog.setContent(this);
            dialog.setDialogContainer(container);
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message.setText(confirmationMessage);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
