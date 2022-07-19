package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTooltip;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    public void initialize() throws Exception {
        System.out.println("1111111111111111111");
        final JFXTooltip burgerTooltip = new JFXTooltip("Open drawer");

        drawer.setOnDrawerOpening(e -> {
            System.out.printf("drawer.onDrawerOpening...");
            burgerTooltip.setText("Close drawer");
            this.changeHamburger(titleBurger, 1);
        });

        drawer.setOnDrawerClosing(e -> {
            System.out.printf("drawer.setOnDrawerClosing");
            burgerTooltip.setText("Open drawer");
            this.changeHamburger(titleBurger, -1);

        });

        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isClosed() || drawer.isClosing()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });


        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/main/MainPopup.fxml"));
        toolbarPopup = new JFXPopup(loader.load());
        optionsBurger.setOnMouseClicked(e -> {
            toolbarPopup.show(optionsBurger,
                    JFXPopup.PopupVPosition.TOP,
                    JFXPopup.PopupHPosition.RIGHT,
                    -12,
                    15);
        });
        JFXTooltip.setVisibleDuration(Duration.millis(3000));
        JFXTooltip.install(titleBurgerContainer, burgerTooltip, Pos.BOTTOM_CENTER);

        SideMenuController.setDrawContent(drawer);
        SideMenuController.setDrawSidePane(drawer);
    }

    private void changeHamburger(JFXHamburger hamburger, int rate) {
        Transition transition = hamburger.getAnimation();
        transition.setRate(rate);
        transition.play();
    }
}
