package com.example.fxjfoenix2;

import com.jfoenix.assets.JFoenixResources;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getClassLoader().getResource("fxml/Main-view.fxml"));

        double width = 800;
        double heigh = 600;
        try {
            Rectangle2D bounds = Screen.getScreens().get(0).getBounds();
            width = bounds.getWidth() / 2.5;
            heigh = bounds.getHeight() / 1.35;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("width:" + width);
            System.out.println("heigh:" + heigh);
        }
        Scene scene = new Scene(fxmlLoader.load(), width, heigh);
        primaryStage.setTitle("Hello!");

        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.addAll(JFoenixResources.load("css/jfoenix-fonts.css").toExternalForm(),
//                MainApp.class.getClassLoader().getResource("css/com/example/jfoenix-main-demo.css").toExternalForm(),
                JFoenixResources.load("css/jfoenix-design.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
