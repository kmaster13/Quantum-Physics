package com.ssau.tk.quantumphysics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuController {

    @FXML
    protected void onExitButtonActionClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onRezerfordButtonClick(ActionEvent event) throws IOException {
        URL resource = MenuController.class.getResource("rezerford.fxml");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root1 = fxmlLoader.load();
        stage.setTitle("Резерфорд");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    protected void onTompsonButtonClick(ActionEvent event) throws IOException {
        URL resource = MenuController.class.getResource("tompson.fxml");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root1 = fxmlLoader.load();
        stage.setTitle("Томпсон");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}