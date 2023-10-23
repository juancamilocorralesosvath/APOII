package com.example.demo;

import controller.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label welcomeText;
    @FXML
    private TextArea inputInfoTextArea;
    @FXML
    private TableView<User> studentsTableView;
    // la idea es que cada una de estas columnas sabra que tipo de dato manejara y
    // va a buscar un atributo de tipo: String para el noombre, String para el id,
    // Integer para la edad. Y asi
    @FXML
    private TableColumn<User, String> nameTC;
    @FXML
    private TableColumn<User, String> idTC;
    @FXML
    private TableColumn<User, Integer> ageTC;

    @FXML
    protected void onHelloButtonClick() {
        HelloApplication.openWindow("form-add-student.fxml");
    }

    // inicializa los recursos de nuestra tabla. cuando ejectumeos el programa o cuando ocurra un evento, se actualiza la vista
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // este metodo implementa un patron de arquitectura que se llama el factoring method (patron de arquitectura de tipo creacional).
        // la manera en como se llama el metodo es muy similar a cuando creamos una hashtable, pues me parece a mi.
        // porque los tipos de datos se lo indicamos con generics y java infiere los tipos de datos
        // cuando nosotros instanciamos cada una de las variables (nameTC, idTC, ageTC)
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("years"));

        studentsTableView.setItems(UserController.getInstance().getStudents());

    }
}