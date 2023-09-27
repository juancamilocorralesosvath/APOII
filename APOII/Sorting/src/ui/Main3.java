package ui;

import model.ComparatorDate;
import model.PersonSorting;
import model.Sorting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Main3 {

    public static void main(String[] args) {
        ArrayList<PersonSorting> list = new ArrayList<>();
        // getInstance: con el getInstance tenemos un unico objeto calendar.
        // OJO: revisar y escribir lo de singleton (clase filemanager en la carpeta de persistencia en el repo del profe)
        // la idea es respetar el principio de unica responsabilidad
        Calendar cal = Calendar.getInstance();
        list.add(new PersonSorting("jaime", 50, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new PersonSorting("pepe", 40, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new PersonSorting("3", 30, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new PersonSorting("4", 20, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new PersonSorting("5", 10, cal));


        Sorting sorting = new Sorting();

        ArrayList<PersonSorting> sortedList = sorting.selectionSort(list);
        System.out.println(sortedList);
        for (PersonSorting person:
             sortedList) {
            System.out.println("name: "+person.getName()+"years: "+person.getYears()+"\n") ;
        }
        ComparatorDate comparator = new ComparatorDate();
        Collections.sort(list, comparator);
        System.out.println("*************************");
        for (int i = 0; i < list.size(); i++) {
            // revisar
            System.out.println(list.get(i));
        }
        System.out.println("*************************");
        Comparator<PersonSorting> comparatorName =
                (p1, p2) ->
                    p1.getName().compareTo(p2.getName());
        Collections.sort(list, comparatorName);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
