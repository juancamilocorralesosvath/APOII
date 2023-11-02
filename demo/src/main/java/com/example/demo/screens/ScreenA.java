package com.example.demo.screens;

import com.example.demo.model.Avatar;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class ScreenA extends BaseScreen {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Avatar avatar;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.avatar = new Avatar(this.canvas);
    }
    @Override
    public void paint(){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        avatar.paint();
    }
    public void setOnKeyPressed(KeyEvent event){
        avatar.setOnKeyPressed(event);
    }
    public void setOnKeyReleased(KeyEvent event){
        avatar.setOnKeyReleased(event);
    }
}
