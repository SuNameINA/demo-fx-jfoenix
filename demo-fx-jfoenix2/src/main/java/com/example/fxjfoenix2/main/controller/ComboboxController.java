package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

public class ComboboxController {

    @FXML
    private JFXComboBox<Label> jfxComboBox;

    @FXML
    private JFXComboBox<Label> jfxEditableComboBox;

    public void initialize() throws Exception {

        jfxComboBox.focusedProperty().addListener((observable, oldValuev, newValue) -> this.comboBoxFocusChange(observable, oldValuev, newValue, jfxComboBox));

        jfxEditableComboBox.focusedProperty().addListener((observable, oldValuev, newValue) -> this.comboBoxFocusChange(observable, oldValuev, newValue, jfxEditableComboBox));

        jfxEditableComboBox.getEditor().focusedProperty().addListener((observable, oldValuev, newValue) -> this.comboBoxFocusChange(observable, oldValuev, newValue, jfxEditableComboBox));

        jfxEditableComboBox.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object == null ? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return string == null || string.isEmpty() ? null : new Label(string);
            }
        });
    }

    private void comboBoxFocusChange(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue, JFXComboBox<?> comboBox) {
        if (!newValue) {
            comboBox.validate();
        }
    }
}
