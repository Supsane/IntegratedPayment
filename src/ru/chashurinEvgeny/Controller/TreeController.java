package ru.chashurinEvgeny.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by chashurin on 06.03.2017.
 */
public class TreeController {

    @FXML
    private TreeView<String> treeMO;

    public void initialize() {
        loadTreeItems("sffdsdf", "gdsgsd", "sfsffs", "tknohok");
    }

    public void loadTreeItems(String... rootItems) {
        TreeItem<String> root = new TreeItem<String>("Root Node");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<String>(itemString));
        }

        treeMO.setRoot(root);
    }
}
