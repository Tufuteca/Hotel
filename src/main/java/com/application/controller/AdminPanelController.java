/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Александр
 */
public class AdminPanelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void exit(MouseEvent event) throws IOException {
        confirmExit(); // Вызов метода для подтверждения выхода
    }
    private void confirmExit() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение");
        alert.setHeaderText("Вы уверены, что хотите выйти из учетной записи?");
        alert.setContentText("Нажмите OK для выхода, или CANCEL для продолжения работы.");

        // Отображение диалогового окна и обработка выбора пользователя
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage primaryStage = (Stage) nameField.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader();
    URL xmlUrl = getClass().getResource("/fxml/Auth.fxml");
    loader.setLocation(xmlUrl);
    Parent root = loader.load();

    // Создание новой сцены с новым окном
    Scene newScene = new Scene(root);

    // Установка прозрачности корневого узла новой сцены в 0 (полностью прозрачный)
    root.setOpacity(0);

    // Установка новой сцены
    primaryStage.setScene(newScene);

    // Получение размеров экрана
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    // Определение размеров новой сцены
    double sceneWidth = root.prefWidth(-1);
    double sceneHeight = root.prefHeight(-1);

    // Центрирование окна на экране
    double centerX = (screenBounds.getWidth() - sceneWidth) / 2;
    double centerY = (screenBounds.getHeight() - sceneHeight) / 2;

    primaryStage.setX(centerX);
    primaryStage.setY(centerY);

    // Создание анимации появления (плавного появления из прозрачности)
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), root);
    fadeTransition.setFromValue(0); // Начальное значение прозрачности
    fadeTransition.setToValue(1);   // Конечное значение прозрачности

    // При необходимости можно добавить обработчик события завершения анимации
    fadeTransition.setOnFinished(event -> {
        // Действия, которые нужно выполнить после завершения анимации
    });

    // Запуск анимации появления
    fadeTransition.play();
        }
    }
    
    
    @FXML
    private ComboBox<String> roleBox;
    @FXML
    private TextField nameField,surnameField,patronymicField,loginField,passwordField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roleBox.getItems().add("Администратор");
        roleBox.getItems().add("Руководитель");
        roleBox.getItems().add("Складской рабочий");
        nameField.setFocusTraversable(false);
        surnameField.setFocusTraversable(false);
        patronymicField.setFocusTraversable(false);
        loginField.setFocusTraversable(false);
        passwordField.setFocusTraversable(false);
        }      
    
}
