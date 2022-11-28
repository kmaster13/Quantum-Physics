package com.ssau.tk.quantumphysics.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.controllers.ControllerUtils.setWindow;

public class Introduction {

    @FXML
    protected void onMenuButtonAction(ActionEvent event) throws IOException {
        setWindow("menu.fxml", event, "Меню");
    }
}
