package ui;

import model.*;

import java.util.Scanner;
public class Main {

    private GenericLinkedList<String> genericLinkedList;
    private Scanner sc;

    public Main(){
        // quiero ver si de esta manera lo infiere
        genericLinkedList = new GenericLinkedList<>();
        sc = new Scanner(System.in);
       // initUsers();
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
     */
    public void answerOption(int userOption) {
        switch (userOption) {
            case 0:
                System.out.println("closing app...");
                break;
            case 1:
                addNode();
                break;
            case 2:
                printList();
                break;
        }
    }
    public void addNode(){
        System.out.println("please specify what do you want to add: ");
        String ans = sc.nextLine();
        genericLinkedList.add(ans);
    }
    public void printList(){
        System.out.println(genericLinkedList.printList());
    }
    /**
     * Metodo que muestra el menu de la aplicacion
     */
    public int showMenuAndGetOption() {
        int input;
        System.out.println("\n app menu"+
                "\n (1) add node" +
                "\n (2) print list"+
                "\n(0) exit"
        );
        input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    /*
    * comentario acerca de las excepciones:
    * ojo: las excepciones runtime exception no necesito controlarlas explicitamente ni declararlas explicitamente.
    * las que heredan de ella tampoco
    * las que heredan de excpetion es necesario decir explicitamente que la voy a usar y manejarla
    *
    * */

    /*
    *
    * try{
    *   division de enteros
    * }catch(InputMismatchException ime){
    *
    *   si lo recibido no es numerico
    *
    * }catch(ArithmeticException a){
    *     si hay una division por cero
    * }
    *
    * puedo escribir lo mismo de arriba de la siguiente manera(syntactic sugar):
    * catch(InputMismatchException | ArithmeticException ex){
    *   if(ex instanceof InputMismatchException) Sysout("el valor ingresado no es numerico");
    *   else Sysout("division por cero")
    * }
    * */

}