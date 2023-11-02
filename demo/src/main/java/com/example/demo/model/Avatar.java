package com.example.demo.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Avatar {
    // elementos graficos
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<Image> idle;
    private ArrayList<Image> run;
    // referencias espaciales
    private MyVector position;
    // state: idle = 0 | run = 1
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
            // por que se hace modulo?
            graphicsContext.drawImage(idle.get(frame%3), position.getPosX(), position.getPosY());
            frame++;
        } else if (state == 1) {
            graphicsContext.drawImage(run.get(frame%5), position.getPosX(), position.getPosY());
            frame++;
        }
    }

    public void onMove(){
        if (upPressed) position.setPosY(position.getPosY() - 10);

        if(downPressed) position.setPosY(position.getPosY() + 10);

        if (leftPressed) position.setPosX(position.getPosX() - 10);

        if (rightPressed) position.setPosX(position.getPosX() + 10);
    }

    public void setOnKeyPressed(KeyEvent event) {
        switch (event.getCode()){
            case UP -> {
                state = 1;
                upPressed = true;
            }
            case DOWN -> {
                state = 1;
                downPressed = true;
            }
            case LEFT -> {
                state = 1;
                leftPressed = true;
            }
            case RIGHT -> {
                state = 1;
                rightPressed = true;
            }
        }
    }

    public void setOnKeyReleased(KeyEvent event) {
        switch (event.getCode()){
            case UP -> {
                state = 0;
                upPressed = false;
            }
            case DOWN -> {
                state = 0;
                downPressed = false;
            }
            case LEFT -> {
                state = 0;
                leftPressed = false;
            }
            case RIGHT -> {
                state = 0;
                rightPressed = false;
            }
        }
    }
}
