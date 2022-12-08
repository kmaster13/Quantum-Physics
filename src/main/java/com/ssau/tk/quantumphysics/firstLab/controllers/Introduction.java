package com.ssau.tk.quantumphysics.firstLab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.FirstLabControllerUtils.setWindow;

public class Introduction {

    @FXML
    protected void onMenuButtonAction(ActionEvent event) throws IOException {
        setWindow("menu1.fxml", event, "Меню");
    }
}
