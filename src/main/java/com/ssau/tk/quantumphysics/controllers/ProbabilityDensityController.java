package com.ssau.tk.quantumphysics.controllers;

import com.ssau.tk.quantumphysics.models.Constants;
import com.ssau.tk.quantumphysics.models.ProbabilityDensity;
import com.ssau.tk.quantumphysics.models.ProbabilityTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

import static com.ssau.tk.quantumphysics.controllers.ControllerUtils.setWindow;

public class ProbabilityDensityController {

    private final ObservableList<ProbabilityTableModel> ProbData = FXCollections.observableArrayList();

    @FXML
    private TableView<ProbabilityTableModel> tableProb;

    @FXML
    private TableColumn<ProbabilityTableModel, Double> angle;

    @FXML
    private TableColumn<ProbabilityTableModel, Double> rutherfordProb;

    @FXML
    private TableColumn<ProbabilityTableModel, Double> thompsonProb;

    @FXML
    private TableColumn<ProbabilityTableModel, Double> realProb;

    private final List<Double> angleList = Constants.probList;

    private final List<Double> rutherfordPropList = ProbabilityDensity.rutherford(angleList);

    private final List<Double> thompsonPropList = ProbabilityDensity.thompson(angleList);
    private final List<Double> realProbList = Constants.realProbList;


    @FXML
    private void initialize() {
        initData();
        initColumns();
    }

    @FXML
    protected void getToMainWindow(ActionEvent event) throws IOException {
        setWindow("menu.fxml", event, "Меню");
    }

    private void initColumns() {
        angle.setCellValueFactory(new PropertyValueFactory<>("angle"));
        rutherfordProb.setCellValueFactory(new PropertyValueFactory<>("rutherfordProb"));
        realProb.setCellValueFactory(new PropertyValueFactory<>("realProb"));
        thompsonProb.setCellValueFactory(new PropertyValueFactory<>("thompsonProb"));
    }

    private void initData() {
        for (int i = 0; i < angleList.size(); i++) {
            ProbData.add(new ProbabilityTableModel(
                    angleList.get(i), rutherfordPropList.get(i), thompsonPropList.get(i), realProbList.get(i)
            ));
            tableProb.setItems(ProbData);
        }
    }
}
