package ui;

import model.Person;
import model.PersonList;
import model.Pet;

import java.io.IOException;

public class Main2 {
    private PersonList listToSave;
    private PersonList listToLoad;
    public Main2(){
        listToSave = new PersonList();
        listToLoad = new PersonList();
    }

    public static void main(String[] args)  {
        // ruta absoluta --> C:\Users\1007489003\Desktop\APOII
        // ruta relativa --> APOII

        // formas de las rutas absolutas. todos los sistemas operativos tienen maneras diferentes
        // de escribir las rutas absolutas. por eso debemos evitar escrbir a mano las rutas
        // absolutas
        Main2 m = new Main2();
        Person p1 = new Person("juan", "123", 1935);
        Person p2 = new Person("hugo", "123", 1936);
        Person p3 = new Person("paco", "123", 1937);
        Person p4 = new Person("luis", "123", 1938);
        Person p5 = new Person("jose", "123", 1939);
        Person p6 = new Person("maria", "123", 1940);
        Person p7 = new Person("pedro", "123", 1941);

        p1.setPet(new Pet("firulais", 5));
        p2.setPet(new Pet("michinguris", 6));
        p3.setPet(new Pet("firulais3", 7));
        p4.setPet(new Pet("firulais4", 8));
        p5.setPet(new Pet("firulais5", 9));
        p6.setPet(new Pet("firulais6", 10));

        m.listToSave.getPeople().add(p1);
        m.listToSave.getPeople().add(p2);
        m.listToSave.getPeople().add(p3);
        m.listToSave.getPeople().add(p4);
        m.listToSave.getPeople().add(p5);
        m.listToSave.getPeople().add(p6);
        m.listToSave.getPeople().add(p7);

        System.out.println(m.listToSave.print());
        try {
            m.listToSave.save();
        }catch (IOException e){
            e.printStackTrace(); // por qué me sale error?
            System.out.println("error...");
        }
        System.out.println("lista vacia: ");
        System.out.println(m.listToLoad.print());
        try {
            m.listToLoad.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("lista cargada: ");
        System.out.println(m.listToLoad.print());

        System.out.println("ejemplo json: ");
        try {
            m.listToSave.saveToGson();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            System.out.println("informacion del content: ");
            m.listToLoad.loadFromGson();
        }catch (IOException e){
            e.printStackTrace();// por qué me sale error?
            System.out.println("error...");
        }
        System.out.println("people from list to load: ");
        System.out.println(m.listToLoad.print());
        System.out.println("listDirs():");
        m.listToSave.listDirs();
    }
}
