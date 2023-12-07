/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.application.controller;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hibernate.annotations.common.util.StringHelper.root;

/**
 *
 * @author Александр
 */


public class Main extends Application {
    
    
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/fxml/Auth.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);

        // Центрирование окна на экране после его открытия
        primaryStage.setOnShown(event -> primaryStage.centerOnScreen());

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                yOffset = event.getY();
                xOffset = event.getX();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public EntityManager em;
        public void Session(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
        em = emf.createEntityManager();
}

}
