package model;

import java.util.Calendar;

public class PersonSorting implements Comparable<PersonSorting>{
    private String name;
    private Calendar date;
    private int years;

    public PersonSorting(String name, int years, Calendar date) {
        this.name = name;
        this.years = years;
        this.date = date;
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
        int result;
        result = this.name.compareTo(person.getName());
        if(result == 0){
            result = this.years - person.getYears();
        }
        return result;
    }
}
