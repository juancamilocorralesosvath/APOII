package model;
public class User {
    private int id;
    private User next;

    public User(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNext(User next) {
        this.next = next;
    }

    public int getId() {

        return id;
    }

    public User getNext() {
        return next;
    }
    @Override
    public String toString(){
        return "id: " + this.id;
    }
}
