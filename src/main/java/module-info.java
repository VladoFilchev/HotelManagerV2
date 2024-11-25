module com.example.hotelmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires java.sql;
    requires java.desktop;

    opens com.example.hotelmanager to javafx.fxml;
    exports com.example.hotelmanager;
    exports controllers;
    opens controllers to javafx.fxml;
}