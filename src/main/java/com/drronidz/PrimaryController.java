package com.drronidz;

import java.io.IOException;

import de.codecentric.centerdevice.javafxsvg.SvgImageLoaderFactory;
import javafx.fxml.FXML;


public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
