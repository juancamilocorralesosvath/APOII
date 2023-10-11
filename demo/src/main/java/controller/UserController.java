package controller;

import model.User;

import java.util.ArrayList;

public class UserController {
    private ArrayList<User> users;

    public UserController(){
        users = new ArrayList<>();
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
}
