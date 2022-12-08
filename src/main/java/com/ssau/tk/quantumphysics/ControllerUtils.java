package com.ssau.tk.quantumphysics;

import com.ssau.tk.quantumphysics.firstLab.controllers.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ControllerUtils {

    public static void setWindow(String fileName, ActionEvent event, String title) throws IOException {
        URL resource = MenuController.class.getResource(fileName);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root2 = fxmlLoader.<Parent>load();
        stage.setTitle(title);
        stage.setScene(new Scene(root2));
        stage.show();
    }
}
