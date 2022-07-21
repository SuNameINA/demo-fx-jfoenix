package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;

public class CheckBoxController {

    @FXML
    private JFXCheckBox checkBox1;

    @FXML
    private JFXCheckBox checkBox2;

    @FXML
    private JFXCheckBox checkBox3;

    @FXML
    private JFXButton button1;

    public void initialize() throws Exception {
        button1.setOnMouseClicked(e -> {
            StringBuilder builder = new StringBuilder();
            if (checkBox1.isSelected()) {
                builder.append("checkBox1 is selected").append(",");
            }
            if (checkBox2.isSelected()) {
                builder.append("checkBox2 is selected").append(",");
            }
            if (checkBox3.isSelected()) {
                builder.append("checkBox3 is selected").append(",");
            }
            String alertStr = builder.length() > 0 ? builder.substring(0, builder.length() - 1) : builder.toString();
            System.out.println(alertStr);
        });
    }

}
