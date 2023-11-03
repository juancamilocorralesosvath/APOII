package com.example.demo.screens;

import com.example.demo.model.Avatar;
import com.example.demo.model.Box;
import com.example.demo.model.IDistance;
import com.example.demo.model.MyVector;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class ScreenA extends BaseScreen {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Avatar avatar;
    private Box box;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.avatar = new Avatar(this.canvas);
        this.box = new Box(this.canvas);

    }
    @Override
    public void paint(){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        avatar.paint();
        box.paint();
        // calculos de distancia
        IDistance distanceCalculator = (from, to) -> {
            return Math.sqrt(
                    Math.pow(from.getPosX() - to.getPosX(), 2) + Math.pow(from.getPosY() - to.getPosY(), 2)
            );
        };
        double distance = distanceCalculator.calculateDistance(avatar.getPosition(), box.getPosition());
        //System.out.println(distance);

        if (distance != 0){
            double posX = avatar.getPosition().getPosX() - box.getPosition().getPosX();
            double posY = avatar.getPosition().getPosY() - box.getPosition().getPosY();

            MyVector diff = new MyVector(posX, posY);
            // para que la animacion del cuadrito sea mas suave
            diff.normalize();
            diff.setSpeed(4);

            box.getPosition().setPosX(box.getPosition().getPosX() + diff.getPosX());
            box.getPosition().setPosY(box.getPosition().getPosY() + diff.getPosY());
        }
    }
    public void setOnKeyPressed(KeyEvent event){
        avatar.setOnKeyPressed(event);
    }
    public void setOnKeyReleased(KeyEvent event){
        avatar.setOnKeyReleased(event);
    }
}
