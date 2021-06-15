module com.drronidz {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafxsvg;
    requires org.junit.jupiter.api;

    opens com.drronidz to javafx.fxml;
    opens com.drronidz.font to javafx.fxml;
    exports com.drronidz;
}