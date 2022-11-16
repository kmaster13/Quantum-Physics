package com.ssau.tk.quantumphysics;

import com.ssau.tk.quantumphysics.models.RezerfordModel;
import com.ssau.tk.quantumphysics.models.TableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RezerfordController implements Initializable {
    private int i = 0;
    private int DEGREE;

    private double VALUE;

    @FXML
    private TextField textField;
    @FXML
    private ComboBox<Integer> comboBox;

    @FXML
    private TableColumn<TableModel, Double> value;

    @FXML
    private TableColumn<TableModel, Double> angle;

    @FXML
    private TableView<TableModel> table;

    @FXML
    private LineChart<?, ?> firstLineChart;
    @FXML
    private LineChart<?, ?> secondLineChart;

    private List<Double> values = new ArrayList<>();

    private List<Double> angles = new ArrayList<>();

    ObservableList<TableModel> list = FXCollections.observableArrayList();

    XYChart.Series series;

    @FXML
    protected void addToTable() {
        DEGREE = comboBox.getValue();
        VALUE = Double.parseDouble(textField.getText());
        textField.clear();

        System.out.println(VALUE + " ," + DEGREE + " ," + RezerfordModel.angle(VALUE, DEGREE));

        values.add(VALUE);
        angles.add(RezerfordModel.angle(VALUE, DEGREE));

        list.add(new TableModel(values.get(i),angles.get(i)));
        table.setItems(list);

        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(0, values.get(i)));
        series1.getData().add(new XYChart.Data(1, values.get(i)));
        series1.getData().add(new XYChart.Data(2, values.get(i)));
        firstLineChart.getData().add(series1);

        createGraph();
        i++;
    }

    private void createGraph(){
        for (int j = 0; j < values.size(); j++) {
            series.getData().add(new XYChart.Data(values.get(j),angles.get(j)));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(FXCollections.observableArrayList(-9,-12));

        value.setCellValueFactory(new PropertyValueFactory<TableModel, Double>("value"));
        angle.setCellValueFactory(new PropertyValueFactory<TableModel, Double>("angle"));


        series = new XYChart.Series();
        secondLineChart.getData().add(series);
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
}
