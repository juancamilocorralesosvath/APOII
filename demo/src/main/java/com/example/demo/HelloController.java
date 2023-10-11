package com.example.demo;

import controller.UserController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    private UserController controller;

    public HelloController() {
        this.controller = new UserController();
    }

    @FXML
    private Label welcomeText;
    @FXML
    private TextArea inputInfoTextArea;

    @FXML
    protected void onHelloButtonClick() {
        String inputData = inputInfoTextArea.getText();
        String[] partialData = inputData.split(",");
        controller.addUser(partialData[0], partialData[1], Integer.parseInt(partialData[2]));
        welcomeText.setText(controller.printUsers());
    }
}