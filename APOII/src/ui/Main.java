package ui;

import java.util.Scanner;
import model.*;
public class Main {

    private UserController controller;
    private Scanner sc;

    public Main(){
        controller = new UserController();
        sc = new Scanner(System.in);
        initUsers();
    }

    public static void main(String[] args) {
        Main m = new Main();
        // variable para leer la entrada
        int option= 0;

        //ciclo para ejecutar el menu mientras que el usuario no
        // elija la opciOn para salir (0)
        do {
            option = m.showMenuAndGetOption();
            m.answerOption(option);
        }while (option !=0);
    }

    /**
     * Metodo que se encarga de llamar a los mEtodos que resuelven cada uno de los
     * requerimientos de la aplicaciOn
     * @param userOption, int es el nUmero ingresado por el usuario (no ha sido validado)
     */
    public void answerOption(int userOption) {
        switch (userOption) {
            case 0:
                System.out.println("cerrando la aplicaciOn, bye");
                break;
            case 1:
                addUser();
                break;
            case 2:
                searchUser();
                break;
            case 3:
                deleteUser();
                break;
            case 4:
                printUsers();
                break;
            case 5:

        }
    }
    private void deleteUser() {

    }

    private void searchUser() {

    }

    private void addUser() {

    }

    private void initUsers(){
        for (int i = 0; i< 10; i++){
            controller.addLastUser(new User(i));
        }
    }

    private void printUsers(){
        System.out.println(controller.print());
    }

    /**
     * Metodo que muestra el menu de la aplicaciOn, a este metod hace falta implementar la validaciOn
     * del valor ingresado por el usuario
     * @return input, int es la opciOn elegida por el usuario
     */
    public int showMenuAndGetOption() {
        int input;
        System.out.println("\n\nMenu de la aplicación, digite una opciOn\n"+
                "(1) agregar model.User\n" +
                "(2) buscar model.User\n" +
                "(3) eliminar model.User\n"+
                "(4) opciOn 4\n"+
                "(5) opciOn 5\n"+
                "(0) Para salir"

        );
        input = sc.nextInt();
        sc.nextLine();
        return input;
    }


}