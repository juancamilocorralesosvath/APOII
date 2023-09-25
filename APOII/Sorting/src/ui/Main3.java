package ui;

import model.PersonSorting;
import model.Sorting;

import java.util.ArrayList;

public class Main3 {

    public static void main(String[] args) {
        ArrayList<PersonSorting> list = new ArrayList<>();
        list.add(new PersonSorting("jaime", 50));
        list.add(new PersonSorting("pepe", 40));
        list.add(new PersonSorting("3", 30));
        list.add(new PersonSorting("4", 20));
        list.add(new PersonSorting("5", 10));

        Sorting sorting = new Sorting(list);

        ArrayList<PersonSorting> sortedList = sorting.selectionSort();
        System.out.println(sortedList);
    }
}
