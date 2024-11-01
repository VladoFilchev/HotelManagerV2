module com.example.hotelmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    requires java.sql;

    opens com.example.hotelmanager to javafx.fxml;
    exports com.example.hotelmanager;
}