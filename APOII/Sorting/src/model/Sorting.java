package model;

import java.util.ArrayList;

public class Sorting<T extends Comparable<T>> {

    public ArrayList<T> selectionSort(ArrayList<T> listToSort){
        int n = listToSort.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listToSort.get(i).compareTo(listToSort.get(j)) > 0) {
                    T prev = listToSort.get(i);
                    T current = listToSort.get(j);
                    listToSort.set(i, current);
                    listToSort.set(j, prev);
                }
            }
        }
        return listToSort;
    }

    public ArrayList<T> insertionSort(ArrayList<T> listToSort){
        for (int i = 1; i < listToSort.size(); i++) {
            T current = listToSort.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(listToSort.get(j)) < 0){
                listToSort.set(j+1, listToSort.get(j));
                --j;
            }
            listToSort.set(j+1, current);
        }
        return listToSort;
    }
}
