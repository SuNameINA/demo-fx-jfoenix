package com.example.fxjfoenix2.main.controller;

import com.example.fxjfoenix2.main.model.bo.SideContentNodeBO;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
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
//                    case "combobox2":
//                        labelIdAndNodeMap.put(label.getId(), SideMenuController.load(label.getId(), "fxml/main/Combobox2.fxml"));
//                        break;
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
                    labelIdAndNodeMap.get(newLabel.getId());
                    drawer.setContent(labelIdAndNodeMap.get(newLabel.getId()).getNode());

                });
                System.out.println("sideList................" + sideList.getItems().get(0));
            }
        });
        drawer.setSidePane(sideMenuStackPane);
    }

//    public static void setDrawContent(JFXDrawer drawer) throws Exception {
//        FXMLLoader drawerContentLoader = new FXMLLoader(SideMenuController.class.getClassLoader().getResource("fxml/main/Button.fxml"));
//        defaultDisplayNode = SideMenuController.load("button", );
//        drawer.setContent(defaultDisplayNode);
//    }

    private static SideContentNodeBO load(String id, String viewPath) throws IOException {
        SideContentNodeBO nodeBO = new SideContentNodeBO();
        nodeBO.setId(id);
        nodeBO.setViewPath(viewPath);
        nodeBO.setLoader(new FXMLLoader(SideMenuController.class.getClassLoader().getResource(viewPath)));
        nodeBO.setNode(nodeBO.getLoader().load());
        return nodeBO;
    }
}
