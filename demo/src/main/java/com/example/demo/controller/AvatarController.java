package com.example.demo.controller;

import com.example.demo.screens.ScreenA;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;

public class AvatarController implements Initializable {
    private ScreenA screenA;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    // cuando se crga la vista grafica se llama a est metodo, ese es el chiste
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.graphicsContext = canvas.getGraphicsContext2D();
        screenA = new ScreenA(this.canvas);

        new Thread(() -> {
            while (true){
                Platform.runLater(()->{
                    paint();
                });
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public void paint(){
        screenA.paint();
    }
    public void initActions(){
        canvas.setOnKeyReleased(event -> {
            screenA.setOnKeyReleased(event);
        });
        canvas.setOnKeyPressed(event -> {
            screenA.setOnKeyPressed(event);
        });
    }
}
