package com.ssau.tk.quantumphysics;

import com.ssau.tk.quantumphysics.models.ProbabilityDensity;
import com.ssau.tk.quantumphysics.models.TableModel;
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

    private ObservableList<TableModel> ProbData = FXCollections.observableArrayList();

    @FXML
    private TableView<TableModel> tableProb;

    @FXML
    private TableColumn<TableModel, Double> angle;

    @FXML
    private TableColumn<TableModel, Double> prob;

    private final List<Double> angleList = ProbabilityDensity.getAngleList();

    private List<Double> probList = ProbabilityDensity.rutherford();

    @FXML
    private void initialize() {

        // устанавливаем тип и значение которое должно хранится в колонке
        initData();
        angle.setCellValueFactory(new PropertyValueFactory<>("angle"));
        prob.setCellValueFactory(new PropertyValueFactory<>("value"));
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
            ProbData.add(new TableModel(probList.get(i), angleList.get(i)));
            tableProb.setItems(ProbData);
        }
    }
}
