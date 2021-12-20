module com.example.ltm_doandetai18_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens FXML.ltm_doandetai18_javafx to javafx.fxml;
    exports FXML.ltm_doandetai18_javafx;
    exports DTO;
    opens DTO to javafx.fxml;
}