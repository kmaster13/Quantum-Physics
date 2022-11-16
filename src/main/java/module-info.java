module com.ssau.tk.quantumphysics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ssau.tk.quantumphysics to javafx.fxml;
    exports com.ssau.tk.quantumphysics;
    opens com.ssau.tk.quantumphysics.models to javafx.fxml;
    exports com.ssau.tk.quantumphysics.models;
}