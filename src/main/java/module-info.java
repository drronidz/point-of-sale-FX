module com.drronidz {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.lineawesome;

    exports com.drronidz to javafx.graphics;
    exports com.drronidz.model;
    exports com.drronidz.controller to javafx.fxml;
    exports com.drronidz.controller.drawer to javafx.fxml;

    opens com.drronidz to javafx.fxml;
    opens com.drronidz.controller to javafx.fxml;
    opens com.drronidz.controller.drawer to javafx.fxml;
}