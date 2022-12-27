package com.ssau.tk.quantumphysics.firstLab.controllers;

import com.ssau.tk.quantumphysics.firstLab.models.Constants;
import com.ssau.tk.quantumphysics.firstLab.models.ExposureTime;
import com.ssau.tk.quantumphysics.firstLab.models.ProbabilityDensity;
import com.ssau.tk.quantumphysics.firstLab.models.TimeTableModel;
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
import java.util.List;

public class ExposureTimeController {

    private final ObservableList<TimeTableModel> TimeData = FXCollections.observableArrayList();

    @FXML
    private TableView<TimeTableModel> tableTime;

    @FXML
    private TableColumn<TimeTableModel, Double> timeRezColumn;
    @FXML
    private TableColumn<TimeTableModel, Double> timeTompColumn;
    @FXML
    private TableColumn<TimeTableModel, Double> AngleColumn;

    @FXML
    private TableColumn<TimeTableModel, Double> probRezColumn;
    @FXML
    private TableColumn<TimeTableModel, Double> probTompColumn;

    private final List<Double> angleList = Constants.timeList;

    private final List<Double> rutherfordProbList = ProbabilityDensity.rutherford(angleList);
    private final List<Double> rutherfordTimeList = ExposureTime.angle(rutherfordProbList);
    private final List<Double> thompsonProbList = ProbabilityDensity.thompson(angleList);

    private final List<Double> thompsonTimeList = ExposureTime.angle(thompsonProbList);

    @FXML
    private void initialize() {
        initData();
        initColumns();
    }

    @FXML
    protected void getToMainWindow(ActionEvent event) throws IOException {
        URL resource = MenuController.class.getResource("menu1.fxml");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root1 = fxmlLoader.load();
        stage.setTitle("Меню");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    private void initColumns() {
        AngleColumn.setCellValueFactory(new PropertyValueFactory<>("angle"));
        timeRezColumn.setCellValueFactory(new PropertyValueFactory<>("timeRuther"));
        timeTompColumn.setCellValueFactory(new PropertyValueFactory<>("timeTomp"));
        probRezColumn.setCellValueFactory(new PropertyValueFactory<>("probRuther"));
        probTompColumn.setCellValueFactory(new PropertyValueFactory<>("probTomp"));
    }

    private void initData() {
        for (int i = 0; i < angleList.size(); i++) {
            TimeData.add(new TimeTableModel(
                    angleList.get(i),
                    roundData(rutherfordProbList.get(i)),
                    roundData(rutherfordTimeList.get(i)),
                    roundData(thompsonProbList.get(i)),
                    roundData(thompsonTimeList.get(i))
            ));
            tableTime.setItems(TimeData);
        }
    }

    private double roundData(double data) {
        double temp = Math.round(data * 1000);
        return temp / 1000;
    }
}
