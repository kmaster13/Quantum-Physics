package com.ssau.tk.quantumphysics;

import com.ssau.tk.quantumphysics.models.Constants;
import com.ssau.tk.quantumphysics.models.ExposureTime;
import com.ssau.tk.quantumphysics.models.ProbabilityDensity;
import com.ssau.tk.quantumphysics.models.TimeTableModel;
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
    private TableColumn<TimeTableModel, Double> newListRezColumn;
    @FXML
    private TableColumn<TimeTableModel, Double> newListTompColumn;

    private final List<Double> angleList = Constants.timeList;

    private final List<Double> probList = ProbabilityDensity.rutherford(angleList);

    private final List<Double> timeList = ExposureTime.angle(probList);


    @FXML
    private void initialize() {

        // устанавливаем тип и значение которое должно хранится в колонке
        initData();
        AngleColumn.setCellValueFactory(new PropertyValueFactory<>("angle"));
        timeRezColumn.setCellValueFactory(new PropertyValueFactory<>("timeRuther"));
        timeTompColumn.setCellValueFactory(new PropertyValueFactory<>("timeTomp"));
        newListRezColumn.setCellValueFactory(new PropertyValueFactory<>("probRuther"));
        newListTompColumn.setCellValueFactory(new PropertyValueFactory<>("probTomp"));
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
        for (int i = 0; i < angleList.size(); i++) {
            TimeData.add(new TimeTableModel(angleList.get(i), probList.get(i), timeList.get(i),0.0, 0.0));
            tableTime.setItems(TimeData);
        }
    }
}
