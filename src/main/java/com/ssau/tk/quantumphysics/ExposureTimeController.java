package com.ssau.tk.quantumphysics;

import com.ssau.tk.quantumphysics.models.ProbabilityDensity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ExposureTimeController {

    private final ObservableList<ProbabilityDensity> TimeData = FXCollections.observableArrayList();

    @FXML
    private TableView<ProbabilityDensity> tableTime;

    @FXML
    private TableColumn<ProbabilityDensity, Double> timeRezColumn;
    @FXML
    private TableColumn<ProbabilityDensity, Double> timeTompColumn;
    @FXML
    private TableColumn<ProbabilityDensity, Double> AngleColumn;

    @FXML
    private TableColumn<ProbabilityDensity, Double> newListRezColumn;
    @FXML
    private TableColumn<ProbabilityDensity, Double> newListTompColumn;



    @FXML
    private void initialize() {


        // устанавливаем тип и значение которое должно хранится в колонке
        timeRezColumn.setCellValueFactory(new PropertyValueFactory<ProbabilityDensity, Double>("time"));
        timeTompColumn.setCellValueFactory(new PropertyValueFactory<ProbabilityDensity, Double>("time"));
        newListRezColumn.setCellValueFactory(new PropertyValueFactory<ProbabilityDensity, Double>("newList"));
        newListTompColumn.setCellValueFactory(new PropertyValueFactory<ProbabilityDensity, Double>("newList"));
        tableTime.setItems(TimeData);

    }
    @FXML
    protected void getToMainWindow(ActionEvent event) throws IOException {
        URL resource = MenuController.class.getResource("menu.fxml");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root1 = fxmlLoader.load();
        stage.setTitle("Меню");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    private void initData() {

    }
}
