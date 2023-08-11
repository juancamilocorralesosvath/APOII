package model;

public class UserController {
    private User head;

    private User tail;

    public UserController(){}

    public User getHead() {
        return head;
    }

    public User getTail() {
        return tail;
    }

    public void addFirstUser(User user){
        // when list is empty
        if(this.head == null){
            this.head = user;
            this.tail = user;
        }// already has users. add to the beginning.
        else{
            user.setNext(this.head);
            this.head = user;
        }
    }

    public void addLastUser(User user){

        if(this.head == null){
            this.head = user;
            this.tail = user;
        }else {
            this.tail.setNext(user);
            this.tail = user;
        }
    }
    public String print(){
        return print(this.head);
    }
    private String print(User current){
        String str = "";
        if(this.head == null){
            str = "list is empty";
        } else if (current.getNext() == null) {
            str += " " + current.getId();
        }else {
           str += current.getId() + " " + print(current.getNext());
        }
        return str;
    }
}























