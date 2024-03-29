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
    requires javafx.base;

    exports com.example.fxjfoenix2;
    exports com.example.fxjfoenix2.main.controller;
    exports com.example.fxjfoenix2.main.model.bo;
    exports com.example.fxjfoenix2.main.model.entity;
    exports com.example.fxjfoenix2.hello.controller;

//    exports com.sun.javafx.event to com.jfoenix;
    //--add-exports javafx.base/com.sun.javafx.event=com.jfoenix

    opens com.example.fxjfoenix2;
    opens com.example.fxjfoenix2.main.controller;
    opens com.example.fxjfoenix2.hello.controller;

    opens fxml.main;
    opens fxml.hello;
    opens css;


}