package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;

public class DialogController {

    @FXML
    private JFXButton centerButton;

    @FXML
    private JFXDialog dialog;

    @FXML
    private StackPane root;

    @FXML
    private JFXButton topButton;

    @FXML
    private JFXButton bottomButton;

    @FXML
    private JFXButton rightButton;

    @FXML
    private JFXButton leftButton;

    @FXML
    private JFXButton acceptButton;

    @FXML
    private JFXButton alertButton;

    public void initialize() throws Exception {
        root.getChildren().remove(dialog);

        centerButton.setOnMouseClicked(e -> {
            dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
            dialog.show(root);
        });

        topButton.setOnMouseClicked(e -> {
            dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
            dialog.show(root);
        });

        bottomButton.setOnMouseClicked(e -> {
            dialog.setTransitionType(JFXDialog.DialogTransition.BOTTOM);
            dialog.show(root);
        });

        rightButton.setOnMouseClicked(e -> {
            dialog.setTransitionType(JFXDialog.DialogTransition.RIGHT);
            dialog.show(root);
        });

        leftButton.setOnAction(e -> {
            dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
            dialog.show(root);
        });

        acceptButton.setOnMouseClicked(e -> {
            dialog.close();
        });


        alertButton.setOnMouseClicked(e -> {
            JFXAlert alert = new JFXAlert(alertButton.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
//            alert.initModality(Modality.NONE);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Modal Dialog using JFXAlert"));
            layout.setBody(new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                    " sed do eiusmod tempor incididunt ut labore et dolore magna" +
                    " aliqua. Utenim ad minim veniam, quis nostrud exercitation" +
                    " ullamco laboris nisi ut aliquip ex ea commodo consequat."));
            JFXButton closeButton = new JFXButton("ACCEPT");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(event -> {
                alert.hideWithAnimation();
            });
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        });
    }
}
