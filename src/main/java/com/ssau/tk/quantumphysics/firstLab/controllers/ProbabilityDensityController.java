package com.ssau.tk.quantumphysics.firstLab.controllers;

import com.ssau.tk.quantumphysics.firstLab.models.Constants;
import com.ssau.tk.quantumphysics.firstLab.models.ProbabilityDensity;
import com.ssau.tk.quantumphysics.firstLab.models.ProbabilityTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

import static com.ssau.tk.quantumphysics.FirstLabControllerUtils.setWindow;

public class ProbabilityDensityController {

    private final ObservableList<ProbabilityTableModel> ProbData = FXCollections.observableArrayList();

    @FXML
    private Pane thompsonText;

    @FXML
    private Pane rutherfordText;

    @FXML
    private Button switchButton;

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
    protected void switchText() {
        if (switchButton.getText().equals("Мишень Резерфорда")) {
            thompsonText.setVisible(false);
            rutherfordText.setVisible(true);
            switchButton.setText("Мишень Томсона");
        } else if (switchButton.getText().equals("Мишень Томсона")) {
            thompsonText.setVisible(true);
            rutherfordText.setVisible(false);
            switchButton.setText("Мишень Резерфорда");
        }
    }

    @FXML
    protected void getToMainWindow(ActionEvent event) throws IOException {
        setWindow("menu1.fxml", event, "Меню");
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
                    angleList.get(i),
                    roundData(rutherfordPropList.get(i)),
                    roundData(thompsonPropList.get(i)),
                    roundData(realProbList.get(i))
            ));
            tableProb.setItems(ProbData);
        }
    }

    private double roundData(double data) {
        double temp = Math.round(data * 1000);
        return temp / 1000;
    }
}
