package model;

public class Person {
    private String name;
    private String ID;
    private int year;
    public Person(String name, String ID, int year){
        this.name = name;
        this.ID = ID;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String toString(){
        return "Name: "+ getName() + " ID: "+ getID();
    }
}
