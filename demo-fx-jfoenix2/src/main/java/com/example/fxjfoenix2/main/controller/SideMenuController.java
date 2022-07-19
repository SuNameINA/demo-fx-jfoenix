package com.example.fxjfoenix2.main.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Map;

public class SideMenuController {

    @FXML
    private JFXListView<Label> sideList;

    private static Node defaultDisplayNode;

    private Map<String, Node> labelIdAndNodeMap;

    public void initialize() throws IOException {
        sideList.getItems().stream().forEach(label -> {
            if ("button".equals(label.getId())) {
                labelIdAndNodeMap.put(label.getId(), defaultDisplayNode);
            } else {

            }
        });
    }

    public static void setDrawSidePane(JFXDrawer drawer) throws Exception {
        FXMLLoader drawerSideMenuLoader = new FXMLLoader(SideMenuController.class.getClassLoader().getResource("fxml/main/SideMenu.fxml"));
        StackPane sideMenuStackPane = (StackPane) drawerSideMenuLoader.load();
        sideMenuStackPane.getChildren().stream().forEach(node -> {
            if ("sideList".equals(node.getId())) {
                JFXListView<Label> sideList = (JFXListView<Label>) node;
                sideList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldLabel, newLabel) -> {
                    System.out.println(newLabel.getId());
//                    drawer.setContent(null);
                });
                System.out.println("sideList................" + sideList.getItems().get(0));
            }
        });
        drawer.setSidePane(sideMenuStackPane);
    }

    public static void setDrawContent(JFXDrawer drawer) throws Exception {
        FXMLLoader drawerContentLoader = new FXMLLoader(SideMenuController.class.getClassLoader().getResource("fxml/main/Button.fxml"));
        defaultDisplayNode = drawerContentLoader.load();
        drawer.setContent((StackPane) defaultDisplayNode);
    }

    private static Node load(String viewPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(SideMenuController.class.getClassLoader().getResource(viewPath));
        return loader.load();
    }
}