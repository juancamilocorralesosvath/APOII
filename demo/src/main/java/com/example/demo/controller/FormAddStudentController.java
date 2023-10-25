package com.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormAddStudentController {
    // action event es otro objeto particular de javafx.
    // acciones que puede tener un componente grafico.
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private Button addStudentBtn;
    public void onAddStudent(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String id = idTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());

        UserController.getInstance().addUser(name, id, age);

        // contenedor que nos provee el sistema operativo
        Stage stage = (Stage) addStudentBtn.getScene().getWindow();
        stage.close();
        // no se por que me esta dando error ... preguntar mañana con el poder de Dios
    }
}


























