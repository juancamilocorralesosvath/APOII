package com.example.demo.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Avatar {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<Image> idle;
    private ArrayList<Image> run;
    private MyVector position;
    private int state;
    private int frame;
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    public Avatar(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.state = 0;
        idle = new ArrayList<>();
        run = new ArrayList<>();
        this.position = new MyVector(100, 100);

        for (int i = 0; i <= 3; i++) {
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/idle/adventurer-idle-2-0"+i+".png"));
            idle.add(image);
        }

        for (int i = 0; i <= 3; i++) {
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/run/adventurer-run-0"+i+".png"));
            idle.add(image);
        }
    }

    public void paint(){
        onMove();
        if (state == 0){
            graphicsContext.drawImage(idle.get(frame%3), position.getPosX(), position.getPosY());
            frame++;
        } else if (state == 1) {
            graphicsContext.drawImage(run.get(frame%5), position.getPosX(), position.getPosY());
            frame++;
        }
    }

    public void onMove(){
        if (upPressed){
            position.setPosY(position.getPosY() - 10);
        }
        if(downPressed){
            position.setPosY(position.getPosY() + 10);
        }
        if (leftPressed) position.setPosX(position.getPosX() - 10);
        if (rightPressed) position.setPosX(position.getPosX() + 10);
    }

    public void setOnKeyPressed(KeyEvent event) {
    }

    public void setOnKeyReleased(KeyEvent event) {
    }
}
