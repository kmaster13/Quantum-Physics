module com.ssau.tk.quantumphysics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ssau.tk.quantumphysics.firstLab.models to javafx.fxml;
    exports com.ssau.tk.quantumphysics.firstLab.models;
    exports com.ssau.tk.quantumphysics.firstLab.controllers;
    opens com.ssau.tk.quantumphysics.firstLab.controllers to javafx.fxml;
    exports com.ssau.tk.quantumphysics;
    opens com.ssau.tk.quantumphysics to javafx.fxml;
    exports com.ssau.tk.quantumphysics.secondLab.controllers;
    opens com.ssau.tk.quantumphysics.secondLab.controllers to javafx.fxml;
}