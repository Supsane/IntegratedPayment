package ru.chashurinEvgeny.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class MainController {
    @FXML
    private TreeView<String> treeMO;

    @FXML
    private AnchorPane typeProject;

    @FXML
    private AnchorPane thereProject;

    public void tree(ActionEvent actionEvent) {
        typeProject.setVisible(false);
        typeProject.setManaged(false);
        thereProject.setVisible(true);
        thereProject.setManaged(true);
    }

    public void back(ActionEvent actionEvent) {
        typeProject.setVisible(true);
        typeProject.setManaged(true);
        thereProject.setVisible(false);
        thereProject.setManaged(false);
    }
}
