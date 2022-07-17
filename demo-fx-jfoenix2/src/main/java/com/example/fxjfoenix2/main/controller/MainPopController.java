package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainPopController {

    @FXML
    private JFXListView<?> toolbarPopupList;

    @FXML
    public void initialize() throws IOException {
        toolbarPopupList.setOnMouseClicked(e -> {
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 1) {
                Platform.exit();
            }
        });
    }
}
