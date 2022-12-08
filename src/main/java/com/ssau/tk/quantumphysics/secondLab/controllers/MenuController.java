package com.ssau.tk.quantumphysics.secondLab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.ControllerUtils.setWindow;

public class MenuController {
    @FXML
    protected void onExitButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onIntroductionButtonClick(ActionEvent event) throws IOException {
        setWindow("introduction.fxml", event, "Введение");
    }
}
