package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXHamburger;
import javafx.animation.Transition;
import javafx.fxml.FXML;

public class IconsController {

    @FXML
    private JFXHamburger burger1;

    @FXML
    private JFXHamburger burger2;

    @FXML
    private JFXHamburger burger3;

    @FXML
    private JFXHamburger burger4;

    public void initialize() throws Exception {
        this.bindAction(burger1);
        this.bindAction(burger2);
        this.bindAction(burger3);
        this.bindAction(burger4);

    }

    private void bindAction(JFXHamburger burger) {
        burger.setOnMouseClicked(e -> {
            Transition burgerAnimation = burger.getAnimation();
            burgerAnimation.setRate(burgerAnimation.getRate() * -1);
            burgerAnimation.play();
        });
    }
}
