package model;

public class Person {
    private String name;
    private String ID;
    private int years;
    private Pet pet;
    public Person(String name, String ID, int years){
        this.name = name;
        this.ID = ID;
        this.years = years;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getYear() {
        return years;
    }

    public void setYear(int year) {
        this.years = year;
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
        return "Name: "+ getName() + " ID: "+ getID() + " years: " + getYear() + " Pet: " + getPet();
    }
}
