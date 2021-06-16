package com.drronidz.controller;

import java.io.IOException;

import com.drronidz.Main;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    public void switchToPrimary() throws IOException {
        Main.setRoot("primary");
    }
}