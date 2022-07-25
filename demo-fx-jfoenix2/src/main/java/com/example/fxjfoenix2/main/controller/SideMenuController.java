package com.example.fxjfoenix2.main.controller;

import com.example.fxjfoenix2.main.model.bo.SideContentNodeBO;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SideMenuController {

    @FXML
    private JFXListView<Label> sideList;

    private static Map<String, SideContentNodeBO> labelIdAndNodeMap = new HashMap<>();

    public void initialize() throws Exception {
        sideList.getItems().stream().forEach(label -> {
            try {
                switch (label.getId()) {
                    case "button":
                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Button.fxml"));
                        break;
                    case "checkbox":
                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Checkbox.fxml"));
                        break;
                    case "combobox":
                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Combobox.fxml"));
                        break;
                    case "combobox2":
                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Combobox2.fxml"));
                        break;
                    case "dialogs":
                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Dialog.fxml"));
                        break;
                    case "icons":
                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Icons.fxml"));
                        break;
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
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
                    SideContentNodeBO nodeBO = labelIdAndNodeMap.get(newLabel.getId());
                    drawer.setContent(nodeBO.getNode());
                });
                System.out.println("sideList................" + sideList.getItems().get(0));
            }
        });
        drawer.setSidePane(sideMenuStackPane);
    }

    private static SideContentNodeBO load(String id, String viewPath) throws IOException {
        SideContentNodeBO nodeBO = new SideContentNodeBO();
        nodeBO.setId(id);
        nodeBO.setViewPath(viewPath);
        nodeBO.setLoader(new FXMLLoader(SideMenuController.class.getClassLoader().getResource(viewPath)));
        nodeBO.setNode(nodeBO.getLoader().load());
        return nodeBO;
    }

}
