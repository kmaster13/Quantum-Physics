package com.ssau.tk.quantumphysics.secondLab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.ssau.tk.quantumphysics.SecondLabControllerUtils.setWindow;

public class BalmerFormul {
    @FXML
    protected void onMenuButtonClick(ActionEvent event) throws IOException {
        setWindow("menu2.fxml", event, "Меню");
    }
    @FXML
    protected void onSecBalmerButtonClick(ActionEvent event) throws IOException {
        setWindow("BalmerSecond.fxml", event, "Далее");
    }
}

