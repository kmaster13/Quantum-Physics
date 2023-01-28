package com.ssau.tk.quantumphysics.secondLab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.SecondLabControllerUtils.setWindow;

public class ConstController {
    @FXML
    protected void onMenuButtonClick(ActionEvent event) throws IOException {
        setWindow("menu2.fxml", event, "Меню");
    }
}
