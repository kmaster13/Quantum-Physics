package com.ssau.tk.quantumphysics.secondLab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.SecondLabControllerUtils.setWindow;

public class MenuController {
    @FXML
    protected void onExitButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onIntroductionButtonClick(ActionEvent event) throws IOException {
        setWindow("introduction2.fxml", event, "Введение");
    }

    @FXML
    protected void onPostulatesButtonClick(ActionEvent event) throws IOException {
        setWindow("postulates.fxml", event, "Постулаты Бора");
    }

    @FXML
    protected void onConstsButtonClick(ActionEvent event) throws IOException {
        setWindow("consts.fxml", event, "Константы");
    }
}
