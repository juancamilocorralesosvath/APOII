package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("hello-view.fxml");
    }
    // vamos a renderizar cualquier archivo xml que yo quiera abrir.
    // para poder abrir multiples ventanas (una despues de otra)
    public static void openWindow(String fxml){
        try{
            // carga el recurso que pasamos por parametro
            // el fxmlloader va a la carpeta de recursos de nuestro programa
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            // stage es la ventana del sistema operativo
            Stage stage = new Stage();
            stage.setTitle("Hello World!");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}