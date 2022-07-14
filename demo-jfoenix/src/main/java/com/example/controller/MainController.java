package com.example.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    @FXML
    private JFXHamburger titleBurger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane titleBurgerContainer;

    private JFXPopup toolbarPopup;

    @FXML
    private StackPane optionsBurger;

    @FXML
    public void initialize() throws IOException {
        System.out.println("1111111111111111111");
//        titleBurgerRate = titleBurgerRate * -1;
//        this.changeHamburger(titleBurger, titleBurgerRate);

        drawer.setOnDrawerOpening(e -> {
            System.out.printf("drawer.onDrawerOpening...");
            this.changeHamburger(titleBurger, 1);
        });

        drawer.setOnDrawerClosing(e -> {
            System.out.printf("drawer.setOnDrawerClosing");
            this.changeHamburger(titleBurger, -1);

        });

        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isClosed() || drawer.isClosing()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Main-Pop.fxml"));
        toolbarPopup = new JFXPopup(loader.load());
        optionsBurger.setOnMouseClicked(e -> {
            toolbarPopup.show(optionsBurger,
                    JFXPopup.PopupVPosition.TOP,
                    JFXPopup.PopupHPosition.RIGHT,
                    -12,
                    15);
        });
    }

    private void changeHamburger(JFXHamburger hamburger, int rate) {
        Transition transition = hamburger.getAnimation();
        transition.setRate(rate);
        transition.play();
    }
}
