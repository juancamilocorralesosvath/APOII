package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import model.User;

import java.util.ArrayList;

// vamos a volver esta clase un singleton
public class UserController {
    private static UserController instance;

    private ObservableList<User> users;

    // de esta manera nos aseguramos de que en el programa tengamos
    // una unica instancia de la clase UserController
    // debe cumplir con el principio de unica responsabilidad --> solo se encarga de una cosa.
    // la idea es aplicar el singleton en una unica clase en mi programa
    public static UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }

    private UserController(){
        // este es un objeto muy particula de Javafx.
        // implementa un patron que se llama observer: la idea principal es tener una clase observable y otra que es observadora. Cuando la clase observable genera algun tipo de evento (agregar, eliminar, etc), la clase observadora hace alguna accion.
        users = FXCollections.observableArrayList();
    }
    public void addUser(String name, String id, int years){
        User user = new User(name, id, years);
        users.add(user);
    }
    public String printUsers(){
        String res = "";
        for (User user:
             users) {
            res += user.toString() + " \n ";
        }
        return res;
    }

    public ObservableList<User> getStudents(){
        // para probar:
        // users.add(new User("name", "id", 1234));
        return users;
    }
}
