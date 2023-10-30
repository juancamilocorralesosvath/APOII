module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.demo to javafx.fxml;
    exports com.example.demo;

    // para que todas las clases de este paquete sean visibles al framework de javafx
    exports com.example.demo.controller;
    opens com.example.demo.controller;
    exports com.example.demo.model;
}