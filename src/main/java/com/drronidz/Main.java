package com.drronidz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * JavaFX App
 */

public class Main extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 1200, 650);
        scene.setFill(Color.TRANSPARENT);
//        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Parent loadFXML(String pathType, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/drronidz/"+ pathType +"/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static FXMLLoader loadFXMLoader(String pathType, String fxml) throws IOException {
        return new FXMLLoader(Main.class.getResource("/com/drronidz/"+ pathType +"/"+ fxml + ".fxml"));
    }

    public static Node getNode(String pathType, String fxml) throws IOException {
        FXMLLoader loader =
                new FXMLLoader(Main.class.getResource("/com/drronidz/" + pathType + "/" + fxml + ".fxml"));
        return loader.load();
    }

}