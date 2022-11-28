module com.ssau.tk.quantumphysics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ssau.tk.quantumphysics.models to javafx.fxml;
    exports com.ssau.tk.quantumphysics.models;
    exports com.ssau.tk.quantumphysics.controllers;
    opens com.ssau.tk.quantumphysics.controllers to javafx.fxml;
}