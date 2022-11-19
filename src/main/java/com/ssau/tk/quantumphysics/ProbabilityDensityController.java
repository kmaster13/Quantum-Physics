package com.ssau.tk.quantumphysics;

import com.ssau.tk.quantumphysics.models.Constants;
import com.ssau.tk.quantumphysics.models.ProbabilityDensity;
import com.ssau.tk.quantumphysics.models.ProbabilityTableModel;
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

        // устанавливаем тип и значение которое должно хранится в колонке
        initData();
        angle.setCellValueFactory(new PropertyValueFactory<>("angle"));
        rutherfordProb.setCellValueFactory(new PropertyValueFactory<>("rutherfordProb"));
        realProb.setCellValueFactory(new PropertyValueFactory<>("realProb"));
        thompsonProb.setCellValueFactory(new PropertyValueFactory<>("thompsonProb"));
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
            ProbData.add(new ProbabilityTableModel(
                    angleList.get(i), rutherfordPropList.get(i), thompsonPropList.get(i), realProbList.get(i)
            ));
            tableProb.setItems(ProbData);
        }
    }
}
