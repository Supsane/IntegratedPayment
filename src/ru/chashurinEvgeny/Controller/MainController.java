package ru.chashurinEvgeny.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import ru.chashurinEvgeny.Main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    public Button sTerPlan;
    public Button genPlan;
    public Button projectPlan;
    public TextField searchTextField;
    public AnchorPane typeProject;
    public AnchorPane thereProject;
    public TreeView treeMO;
    public AnchorPane mainPanel;


    public void addMainPanel(ActionEvent actionEvent) {
        typeProject.setVisible(false);
        typeProject.setManaged(false);
        thereProject.setVisible(true);
        thereProject.setManaged(true);
        mainPanel.setVisible(true);
        mainPanel.setManaged(true);
        if (sTerPlan.isPressed()) Main.mainStage.setTitle("Комплексный расчет: Схема территориального планирования");
    }

    public void back(ActionEvent actionEvent) {
        typeProject.setVisible(true);
        typeProject.setManaged(true);
        thereProject.setVisible(false);
        thereProject.setManaged(false);
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    TreeItem <String> tiRF = new TreeItem<String>("Российская Федерация");

    TreeItem <String> tiAltay = new TreeItem<String>("Алтайский Край");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        treeMO.setRoot(tiRF);
        tiRF.getChildren().add(tiAltay);
    }
}
