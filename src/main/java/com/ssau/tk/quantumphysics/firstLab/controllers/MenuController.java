package com.ssau.tk.quantumphysics.firstLab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.ControllerUtils.setWindow;

public class MenuController {

    @FXML
    protected void onExitButtonActionClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onIntroductionButtonClick(ActionEvent event) throws IOException {
        setWindow("introduction1.fxml", event, "Введение");
    }

    @FXML
    protected void onRezerfordButtonClick(ActionEvent event) throws IOException {
        setWindow("rezerford.fxml", event, "Резерфорд");
    }

    @FXML
    protected void onTompsonButtonClick(ActionEvent event) throws IOException {
        setWindow("tompson.fxml", event, "Томпсон");
    }

    @FXML
    protected void onVerButtonClick(ActionEvent event) throws IOException {
        setWindow("ver.fxml", event, "Вероятность");
    }
    @FXML
    protected void onTimeButtonClick(ActionEvent event) throws IOException {
        setWindow("time.fxml", event, "Резерфорд");
    }
}