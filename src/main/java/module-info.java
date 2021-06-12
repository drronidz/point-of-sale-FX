module com.drronidz {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens com.drronidz to javafx.fxml;
    exports com.drronidz;
}