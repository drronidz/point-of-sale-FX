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
    exports com.drronidz.controller.drawer.side.filter to javafx.fxml;
    exports com.drronidz.controller.drawer.side.form to javafx.fxml;
    exports com.drronidz.controller.dialog to javafx.fxml;
    exports com.drronidz.controller.container to javafx.fxml;
    exports com.drronidz.controller.card to javafx.fxml;
    exports com.drronidz.controller.component to javafx.fxml;
    exports com.drronidz.controller.table to javafx.fxml;

    exports com.drronidz.tools to javafx.fxml;

    opens com.drronidz to javafx.fxml;
    opens com.drronidz.controller to javafx.fxml;
    opens com.drronidz.controller.drawer to javafx.fxml;
    opens com.drronidz.controller.drawer.side.filter to javafx.fxml;
    opens com.drronidz.controller.drawer.side.form to javafx.fxml;
    opens com.drronidz.controller.listcell to javafx.fxml;
    opens com.drronidz.controller.dialog to javafx.fxml;
    opens com.drronidz.controller.container to javafx.fxml;
    opens com.drronidz.controller.card to javafx.fxml;
    opens com.drronidz.controller.component to javafx.fxml;
    opens com.drronidz.controller.table to javafx.fxml;

    opens com.drronidz.tools to javafx.fxml;
}