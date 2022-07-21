package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;

import java.util.HashSet;
import java.util.Set;

public class CheckBoxController {

    @FXML
    private JFXCheckBox checkBox1;

    @FXML
    private JFXCheckBox checkBox2;

    @FXML
    private JFXCheckBox checkBox3;

    @FXML
    private JFXButton button1;

    Set<JFXCheckBox> selectedChekBox = new HashSet<>();

    public void initialize() throws Exception {
        checkBox1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue.equals(Boolean.TRUE)) {
                    selectedChekBox.add(checkBox1);
                } else {
                    selectedChekBox.remove(checkBox1);
                }
            }
        });

        checkBox2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue.equals(Boolean.TRUE)) {
                    selectedChekBox.add(checkBox2);
                } else {
                    selectedChekBox.remove(checkBox2);
                }
            }
        });

        checkBox3.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue.equals(Boolean.TRUE)) {
                    selectedChekBox.add(checkBox3);
                } else {
                    selectedChekBox.remove(checkBox3);
                }
            }
        });
        button1.setOnMouseClicked(e -> {
            StringBuilder builder = new StringBuilder();
//            if (checkBox1.isSelected()) {
//                builder.append("checkBox1 is selected").append(",");
//            }
//            if (checkBox2.isSelected()) {
//                builder.append("checkBox2 is selected").append(",");
//            }
//            if (checkBox3.isSelected()) {
//                builder.append("checkBox3 is selected").append(",");
//            }
//            String alertStr = builder.length() > 0 ? builder.substring(0, builder.length() - 1) : builder.toString();
//            System.out.println(alertStr);

            for (JFXCheckBox checkBox : selectedChekBox) {
                if (builder.length() > 0) {
                    builder.append(",");
                }
                builder.append(checkBox.getId());
            }
            System.out.println(builder.toString());
        });
    }

}
