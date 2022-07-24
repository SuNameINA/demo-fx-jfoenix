package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Combobox2Controller {

    @FXML
    private JFXComboBox<Label> jfxComboBox;

    public void initialize() throws Exception {
        ObservableList<Label> items = FXCollections.observableArrayList();
        items.add(new Label("Label 1"));
        items.add(new Label("Label 2"));
        items.add(new Label("Label 3"));
        items.add(new Label("Label 4"));
        jfxComboBox.setItems(items);
    }


}
