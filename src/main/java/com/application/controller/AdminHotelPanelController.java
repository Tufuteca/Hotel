/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.application.controller;

import com.application.entity.Room;
import com.application.entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Александр
 */
public class AdminHotelPanelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField name;
    @FXML
    Text username;
    @FXML
    TableView roomTable;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getAuthUsername();
        displayRoomsInTableView(roomTable);
        
    }
    
    
    
    
    
    //Код кнопок и прочие методы
    public void displayRoomsInTableView(TableView<Room> roomTable) {
        Main m = new Main();
        m.Session();
        // Получаем список объектов Room
        Room r = new Room();
        List<Room> roomList = r.getRoomList(m.em);

        // Создаем колонки для TableView для каждого поля
        TableColumn<Room, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idRoom"));

        TableColumn<Room, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfRoom"));

        TableColumn<Room, Integer> numberColumn = new TableColumn<>("Room Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfRoom"));

        TableColumn<Room, String> descColumn = new TableColumn<>("Description");
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Room, Double> areaColumn = new TableColumn<>("Area");
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));

        TableColumn<Room, Integer> seatsColumn = new TableColumn<>("Number of Seats");
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSeats"));

        TableColumn<Room, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Room, Boolean> deletedColumn = new TableColumn<>("Deleted");
        deletedColumn.setCellValueFactory(new PropertyValueFactory<>("deleted"));

        // Устанавливаем данные в таблицу
        ObservableList<Room> data = FXCollections.observableArrayList(roomList);
        roomTable.setItems(data);

        // Добавляем все созданные колонки в TableView
        roomTable.getColumns().addAll(idColumn, typeColumn, numberColumn, descColumn, 
                                      areaColumn, seatsColumn, priceColumn, deletedColumn);
}

    //Выводим имя пользователя 
    private void getAuthUsername(){
        Main m = new Main();
        m.Session();
        AuthController ac = new AuthController();
        for(User u: new User().getUserList(m.em)){
            if(u.getIdUser()==ac.getId()){
                username.setText(u.getSurname()+" "+u.getName()+" "+u.getPatronymic());
                break;
            }
        }
    }
    private void fillTables(){
        Main m = new Main();
        m.Session();
        for(Room r: new Room().getRoomList(m.em)){
            
        }
    }
    
    //Обработка кнопки выхода
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
            Stage primaryStage = (Stage) name.getScene().getWindow();
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
}
