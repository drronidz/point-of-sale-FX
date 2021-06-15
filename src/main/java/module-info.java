module com.drronidz {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.lineawesome;


    opens com.drronidz to javafx.fxml;
    exports com.drronidz;
}