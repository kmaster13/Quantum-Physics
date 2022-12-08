package com.ssau.tk.quantumphysics.firstLab.controllers;

import com.ssau.tk.quantumphysics.firstLab.models.RezerfordModel;
import com.ssau.tk.quantumphysics.firstLab.models.TableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.ssau.tk.quantumphysics.FirstLabControllerUtils.setWindow;

public class RezerfordController implements Initializable {
    private int i = 0;
    private int DEGREE;

    private double VALUE;

    private boolean isCorrect;

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

    @FXML
    private Text errorComboBox;

    @FXML
    private Text errorTextField;

    private List<Double> values = new ArrayList<>();

    private List<Double> angles = new ArrayList<>();

    ObservableList<TableModel> list = FXCollections.observableArrayList();

    XYChart.Series series;

    @FXML
    protected void addToTable() {
        isCorrect = true;
        if (i != 0 && DEGREE != comboBox.getValue()) {
            errorComboBox.setText("Выбрана другая степень!");
            isCorrect = false;
        } else {
            DEGREE = comboBox.getValue();
            errorComboBox.setText("");
            firstLineChart.getData().clear();
        }
        try {
            VALUE = Double.parseDouble(textField.getText());
            errorTextField.setText("");
        } catch (Exception e) {
            errorTextField.setText("В поле введено неизвестное значение!");
            isCorrect = false;
        }

        if (isCorrect) {
            textField.clear();

            System.out.println(VALUE + " ," + DEGREE + " ," + RezerfordModel.angle(VALUE, DEGREE));

            values.add(VALUE);
            angles.add(RezerfordModel.angle(VALUE, DEGREE));

            list.add(new TableModel(values.get(i), angles.get(i)));
            table.setItems(list);

            newGraph();

            series.getData().add(new XYChart.Data(values.get(i), angles.get(i)));
            i++;
        }
    }

    private void newGraph(){
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(0, values.get(i)));
        series1.getData().add(new XYChart.Data(1, values.get(i)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //TODO точки строятся в другом порядке
        if(angles.get(i)>0 && angles.get(i) < 90) {
            series1.getData().add(new XYChart.Data(2, values.get(i) + Math.abs(Math.sin(angles.get(i)))));
        } else if(angles.get(i) > 90 && angles.get(i) < 180) {
            series1.getData().add(new XYChart.Data(0, values.get(i) + Math.abs(Math.sin(angles.get(i)))));
        } else {
            series1.getData().add(new XYChart.Data(1, values.get(i) + 1));
        }

        firstLineChart.getData().add(series1);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(FXCollections.observableArrayList(-9, -12));
        comboBox.setValue(-9);

        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        angle.setCellValueFactory(new PropertyValueFactory<>("angle"));


        series = new XYChart.Series();
        secondLineChart.getData().add(series);
    }

    @FXML
    void getReboot(ActionEvent event) throws IOException {
        setWindow("rezerford.fxml", event, "Резерфорд");
    }

    @FXML
    protected void getToMainWindow(ActionEvent event) throws IOException {
        setWindow("menu1.fxml", event, "Меню");
    }
}
