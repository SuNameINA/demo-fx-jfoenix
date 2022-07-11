package com.example;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private JFXHamburger titleBurger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane titleBurgerContainer;

    private int titleBurgerRate = 1;

//    @FXML
//    private void onClickTitleBurger(MouseEvent event) {
//        System.out.println(event);
//        titleBurgerRate = titleBurgerRate * -1;
//        this.changeHamburger(titleBurger, titleBurgerRate);
//    }

    @FXML
    public void initialize() {
        System.out.println("1111111111111111111");
        titleBurgerRate = titleBurgerRate * -1;
        this.changeHamburger(titleBurger, titleBurgerRate);

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
    }

    private void changeHamburger(JFXHamburger hamburger, int rate) {
        Transition transition = hamburger.getAnimation();
        transition.setRate(rate);
        transition.play();
    }
}
