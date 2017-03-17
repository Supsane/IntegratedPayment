package ru.chashurinEvgeny.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout/main.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Комплексный расчет");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.setMinHeight(768.00);
        primaryStage.setMinWidth(1024.00);
        primaryStage.show();
        mainStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
