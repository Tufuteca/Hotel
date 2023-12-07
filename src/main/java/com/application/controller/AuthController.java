package com.application.controller;

import com.application.entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.util.Duration;


public class AuthController implements Initializable {
    @FXML
    TextField loginField, passwordField;
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void exit(MouseEvent event) {
        confirmExit(); // Вызов метода для подтверждения выхода
    }
     
    private void confirmExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение");
        alert.setHeaderText("Вы уверены, что хотите выйти?");
        alert.setContentText("Нажмите OK для выхода, или CANCEL для продолжения работы.");

        // Отображение диалогового окна и обработка выбора пользователя
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0); // Если пользователь нажал OK, закрыть приложение
        }
    }
    
    
    private static int id = 0;
    
    public int getId(){
        return id;
    }
    private void setId(int id){
        this.id = id;
    }
    
    @FXML
    private void Login(ActionEvent event) throws IOException{
    String login = loginField.getText();
    String password = passwordField.getText();
    Main m = new Main();
    m.Session();
    for(User user: new User().getUserLoginPassword(login, password, m.em)){
        id = user.getIdUser();
    }
    if(login.equals("")){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Ошибка! Вы не ввели логин");
        alert.setContentText("Введите логин!");

        Optional<ButtonType> result = alert.showAndWait();
    }else if(password.equals("")){
    }else if(login.equals("admin") && password.equals("admin")) {
        goToAdminForm();
        
    } else if (id!=0){
        for(User u: new User().getUserList(m.em)){
        if(u.getRoleidRole().getRoleTitle().equals("Администратор")){
            goToAdminHotelForm();
        }
        else if(u.getRoleidRole().getRoleTitle().equals("Руководитель")){
            //goToAdminHotelForm();
        }
        else if(u.getRoleidRole().getRoleTitle().equals("Складской рабочий")){
            //goToAdminHotelForm();
        }
        }
}
    else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Ошибка! Неверный логин или пароль");
        alert.setContentText("Проверьте правильность введеных данных!");

        Optional<ButtonType> result = alert.showAndWait();
        }}
    private void goToAdminForm() throws IOException {
    Stage primaryStage = (Stage) loginField.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader();
    URL xmlUrl = getClass().getResource("/fxml/AdminPanel.fxml");
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
    private void goToAdminHotelForm() throws IOException {
    Stage primaryStage = (Stage) loginField.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader();
    URL xmlUrl = getClass().getResource("/fxml/AdminHotelPanel.fxml");
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
    
