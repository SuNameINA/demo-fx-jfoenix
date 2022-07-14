module com.example.fxjfoenix2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.jfoenix;

    opens com.example.fxjfoenix2 to javafx.fxml;
    exports com.example.fxjfoenix2;
    exports com.example.fxjfoenix2.controller;
    opens com.example.fxjfoenix2.controller to javafx.fxml;
}