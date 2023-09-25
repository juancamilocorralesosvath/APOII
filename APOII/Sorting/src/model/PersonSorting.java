package model;

import java.util.Calendar;

public class PersonSorting implements Comparable<PersonSorting>{
    private String name;
    private Calendar date;
    private int years;

    public PersonSorting(String name, int years) {
        this.name = name;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public int compareTo(PersonSorting person) {
        return this.years - person.getYears();
    }
}
