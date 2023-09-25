package model;

import java.util.ArrayList;

public class Sorting {
    private ArrayList<PersonSorting> listToSort;

    public Sorting(ArrayList<PersonSorting> list) {
        this.listToSort = list;
    }
    public ArrayList<PersonSorting> selectionSort(){
        int n = listToSort.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listToSort.get(i).compareTo(listToSort.get(j)) > 0) {
                    PersonSorting prev = listToSort.get(i);
                    PersonSorting current = listToSort.get(j);
                    listToSort.set(i, current);
                    listToSort.set(j, prev);
                }
            }
        }
        return listToSort;
    }
}
