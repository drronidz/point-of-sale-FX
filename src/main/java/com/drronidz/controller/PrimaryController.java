package com.drronidz.controller;

import java.io.IOException;

import com.drronidz.Main;
import javafx.fxml.FXML;


public class PrimaryController {

    @FXML
    public void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
}
