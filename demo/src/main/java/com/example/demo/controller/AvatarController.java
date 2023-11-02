package com.example.demo.controller;

import com.example.demo.screens.BaseScreen;
import com.example.demo.screens.ScreenA;
import javafx.application.Platform;
import javafx.collections.ArrayChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AvatarController implements Initializable {
    private ArrayList<BaseScreen> screens;
    private ScreenA screenA;
    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    // cuando se crga la vista grafica se llama a est metodo, ese es el chiste
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.graphicsContext = canvas.getGraphicsContext2D();
        screenA = new ScreenA(this.canvas);
        initActions();

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
