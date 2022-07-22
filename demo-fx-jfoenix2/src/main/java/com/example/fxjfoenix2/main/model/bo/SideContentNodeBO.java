package com.example.fxjfoenix2.main.model.bo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class SideContentNodeBO {

    private String id;

    private String viewPath;

    private Node node;

    private FXMLLoader loader;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}
