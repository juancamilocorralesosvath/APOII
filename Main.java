package ui;


import model.User;
import model.UserController;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        User user1 = new User(0);

        controller.addFirstUser(user1);
        System.out.println(controller.getHead());

        User user2 = new User(1);
        controller.addFirstUser(user2);

        System.out.println(controller.getHead());


        System.out.println(controller.print());
    }
}