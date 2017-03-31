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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.sql.*;

public class MainController implements Initializable, ConnectService {
    private Connection connection;
    private PreparedStatement psOblastID;
    private PreparedStatement psGorodID;
    private PreparedStatement psRayonID;
    private PreparedStatement psSelsovetID;
    private PreparedStatement psOblastName;
    private PreparedStatement psGorodName;
    private PreparedStatement psRayonName;
    private PreparedStatement psSelsovetName;

    @FXML
    public Button sTerPlan;
    public Button genPlan;
    public Button projectPlan;
    public TextField searchTextField;
    public AnchorPane typeProject;
    public AnchorPane thereProject;
    public TreeView treeMO;
    public AnchorPane mainPanel;

    public MainController() throws SQLException {
    }

    public void setVisibility() {
        typeProject.setVisible(false);
        typeProject.setManaged(false);
        thereProject.setVisible(true);
        thereProject.setManaged(true);
        mainPanel.setVisible(true);
        mainPanel.setManaged(true);
    }

    public void back(ActionEvent actionEvent) {
        typeProject.setVisible(true);
        typeProject.setManaged(true);
        thereProject.setVisible(false);
        thereProject.setManaged(false);
        Main.mainStage.setTitle("Комплексный расчет");
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:IntegratedPayment.db");
            psOblastID = connection.prepareStatement("SELECT Oblast FROM Municipalities;");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*==========================================
*
* Тут должен быть код работы с БД. Вытащить все элементы из базы и забить
* их как мне кажется в массивы, потом сформировать дерево из всего этого
*
* ===========================================*/

    ArrayList<Integer> OblastID = new ArrayList<Integer>();
    ArrayList<Integer> GorodID = new ArrayList<Integer>();
    ArrayList<Integer> RayonID = new ArrayList<Integer>();
    ArrayList<Integer> SelsovetID = new ArrayList<Integer>();
    ArrayList<String> OblastName = new ArrayList<String>();
    ArrayList<String> GorodName = new ArrayList<String>();
    ArrayList<String> RayonName = new ArrayList<String>();
    ArrayList<String> SelsovetName = new ArrayList<String>();

    public void fillOblastID () {
        try {
            ResultSet resPsOblastID = psOblastID.executeQuery();
            while (resPsOblastID.next()) {
                OblastName.add(resPsOblastID.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnectDB() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> tiRF = new TreeItem<String>("Российская Федерация");
        TreeItem<String> tiAltay = new TreeItem<String>("Алтайский Край");

        fillOblastID();
        Iterator<String> itr = OblastName.iterator();
        while (itr.hasNext()) {
            String nameOblast = itr.next();
            TreeItem <String> idTree = new TreeItem<String>(nameOblast);
            tiRF.getChildren().add(idTree);
        }

        treeMO.setRoot(tiRF);
//        tiRF.getChildren().add(tiAltay);
        tiRF.setExpanded(true);
    }

    public void selectProjPlanButton(ActionEvent actionEvent) {
        setVisibility();
        Main.mainStage.setTitle("Комплексный расчет: Проект планировки");
    }

    public void selectGenPlanButton(ActionEvent actionEvent) {
        setVisibility();
        Main.mainStage.setTitle("Комплексный расчет: Генеральный план");
    }

    public void selectTerPlanButton(ActionEvent actionEvent) {
        setVisibility();
        Main.mainStage.setTitle("Комплексный расчет: Схема территориального планирования");
    }
}
