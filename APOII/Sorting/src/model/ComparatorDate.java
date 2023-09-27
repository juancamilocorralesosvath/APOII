package model;

import java.util.Comparator;

public class ComparatorDate implements Comparator<PersonSorting> {
    @Override
    public int compare(PersonSorting p1, PersonSorting p2) {
        return p1.getDate().compareTo(p2.getDate());
    }
}
