package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class IconsController {

    @FXML
    private StackPane root;

    @FXML
    private JFXHamburger burger1;

    @FXML
    private JFXHamburger burger2;

    @FXML
    private JFXHamburger burger3;

    @FXML
    private JFXHamburger burger4;

    @FXML
    private JFXBadge badge1;

    private int badgeClickCount = 1;

    private JFXSnackbar snackbar;

    public void initialize() throws Exception {
        this.bindAction(burger1);
        this.bindAction(burger2);
        this.bindAction(burger3);
        this.bindAction(burger4);

        snackbar = new JFXSnackbar(root);
        snackbar.prefWidth(300);

        badge1.setOnMouseClicked(event -> {
//            badge1.setText(String.valueOf(++badgeClickCount));
            int value = Integer.parseInt(badge1.getText());
            if (event.getButton() == MouseButton.PRIMARY) {
                value++;
            } else if (event.getButton() == MouseButton.SECONDARY) {
                value--;
            }

            if (value == 0) {
                badge1.setEnabled(false);
            } else {
                badge1.setEnabled(true);
            }

            badge1.setText(String.valueOf(value));

            if (badgeClickCount++ % 2 == 0) {
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Toast Message " + badgeClickCount)));
            } else {
                if (badgeClickCount++ % 4 == 0) {
                    snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                            new JFXSnackbarLayout("Snackbar Message Persistent " + badgeClickCount, "CLOSE", action -> snackbar.close()),
                            Duration.INDEFINITE, null));
                } else {
                    snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                            new JFXSnackbarLayout("Snackbar Message " + badgeClickCount, "UNDO", action -> snackbar.close()),
                            Duration.millis(3000), null));
                }
            }
        });
    }

    private void bindAction(JFXHamburger burger) {
        burger.setOnMouseClicked(e -> {
            Transition burgerAnimation = burger.getAnimation();
            burgerAnimation.setRate(burgerAnimation.getRate() * -1);
            burgerAnimation.play();
        });
    }
}
